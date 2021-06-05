package com.cjp.spitter.mvc;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/spitters")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }

    @RequestMapping(value = "/{username}/spittles", method = RequestMethod.GET)
    public String listSpittlesForSpitter(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        List<Spittle> spittlesForSpitter = spitterService.getSpittlesForSpitter(username);
        model.addAttribute(spittlesForSpitter);
        return "spittles/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitters/" + spitter.getUsername();
    }
}