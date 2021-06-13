package com.cjp.spitter.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint /*extends SpringBeanAutowiringSupport*/ {

    @Autowired
    private SpitterService spitterService;

    @WebMethod
    public void addSpittle(Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
        spitterService.deleteSpittle(spittleId);
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
        return spitterService.getRecentSpittles(spittleCount);
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}