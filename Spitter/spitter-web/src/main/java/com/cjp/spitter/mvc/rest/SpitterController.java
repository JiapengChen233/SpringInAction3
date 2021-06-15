package com.cjp.spitter.mvc.rest;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller("RestSpitterController")
@RequestMapping("/rest/spitters")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @ResponseBody
    @RequestMapping(value = "/{username}/spittles", method = RequestMethod.GET)
    public Spittle[] listSpittlesForSpitter(@PathVariable String username) {
        return spitterService.getSpittlesForSpitter(username).toArray(new Spittle[0]);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/spittles/{id}", method = RequestMethod.DELETE)
    public void deleteSpittler(@PathVariable("id") long id) {
        spitterService.deleteSpittle(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void putSpitter(@PathVariable("id") long id, @RequestBody @Valid Spitter spitter) {
        Spitter getSpitter = spitterService.getSpitter(id);
        if (getSpitter == null) {
            throw new IllegalArgumentException("资源不存在！");
        }
        spitterService.saveSpitter(spitter);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Spitter createSpitter(@RequestBody @Valid Spitter spitter, HttpServletResponse response) {
        spitterService.saveSpitter(spitter);
        response.setHeader("Location", "/" + spitter.getId());
        return spitter;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(error.getField() + ": " + error.getDefaultMessage());
        }
    }
}