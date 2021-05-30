package com.cjp.spitter.service;

import com.cjp.spitter.domain.Spitter;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-dataSource-context.xml",
        "classpath:test-service-context.xml",
        "classpath:test-persistence-context.xml"
})
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void shouldAddSpitter() {
        Spitter spitter = new Spitter();
        spitter.setUsername("Ronaldo");
        spitter.setPassword("123456");
        spitter.setFullName("RonaldoChen");
        spitter.setEmail("123@gmail.com");
        spitter.setUpdateByEmail(false);
        spitterService.saveSpitter(spitter);
    }
}
