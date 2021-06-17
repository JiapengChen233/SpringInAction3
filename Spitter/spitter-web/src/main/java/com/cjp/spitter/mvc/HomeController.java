package com.cjp.spitter.mvc;

import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
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

    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }

    @Bean
    public MBeanExporter mBeanExporter(HomeController homeController) {
        MBeanExporter mBeanExporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("spitter:name=HomeController", homeController);
        mBeanExporter.setBeans(beans);
        return mBeanExporter;
    }
}
