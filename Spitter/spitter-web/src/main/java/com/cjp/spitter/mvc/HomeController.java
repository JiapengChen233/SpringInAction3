package com.cjp.spitter.mvc;

import com.cjp.spitter.jmx.HomeControllerManagedOperations;
import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.support.MBeanRegistrationSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@ManagedResource(objectName="spitter:name=HomeController") //将HomeController导出为MBean
public class HomeController {

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles(spittlesPerPage));
        return "home";
    }

    //@ManagedOperation@ManagedOperation注解替换@ManagedAttribute注解来标注存取器方法
    @ManagedAttribute        //将spittlesPerPage暴露为托管属性
    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    //@ManagedOperation@ManagedOperation注解替换@ManagedAttribute注解来标注存取器方法
    @ManagedAttribute        //将spittlesPerPage暴露为托管属性
    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }

//    @Bean
//    public MethodNameBasedMBeanInfoAssembler assembler() {
//        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
//        assembler.setManagedMethods(new String[] {
//                "getSpittlesPerPage", "setSpittlesPerPage"
//        });
//        return assembler;
//    }

    @Bean
    public InterfaceBasedMBeanInfoAssembler assembler() {
        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
        assembler.setManagedInterfaces(new Class[]{HomeControllerManagedOperations.class});
        return assembler;
    }

    @Bean
    public MBeanExporter mbeanExporter(HomeController homeController, MBeanInfoAssembler assembler) {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("spitter:name=HomeController", homeController);
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);
        exporter.setRegistrationBehavior(MBeanRegistrationSupport.REGISTRATION_IGNORE_EXISTING);
        return exporter;
    }
}
