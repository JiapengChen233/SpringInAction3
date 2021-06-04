package com.cjp.spitter.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(Map<String, Object> model) {
        model.put("name", "Ronaldo");
        return "hello"; // 视图名，对应WEB-INF/views/下同名JSP文件
    }
}