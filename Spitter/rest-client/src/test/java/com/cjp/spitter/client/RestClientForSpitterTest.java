package com.cjp.spitter.client;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class RestClientForSpitterTest {

    private RestClientForSpitter client;

    @Before
    public void before() {
        client = new RestClientForSpitter();
    }

    @Test
    public void testUpdateSpitter() throws URISyntaxException {
        Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setUsername("test");
        spitter.setPassword("123456");
        spitter.setFullName("test test");
        spitter.setEmail("123@qq.com");
        spitter.setUpdateByEmail(true);
        client.updateSpitter(spitter);
    }

    @Test
    public void testRetrieveSpittlesForObject() {
        Spittle[] spittles = client.retrieveSpittlesForObject("artnames");
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testRetrieveSpittlesForEntity() {
        Spittle[] spittles = client.retrieveSpittlesForEntity("artnames");
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testDeleteSpittle() throws URISyntaxException {
        client.deleteSpittle(0L);
    }

    @Test
    public void testPostSpitterForObject() {
        Spitter spitter = new Spitter();
        spitter.setId(3L);
        spitter.setUsername("test");
        spitter.setPassword("123456");
        spitter.setFullName("test test");
        spitter.setEmail("123@qq.com");
        spitter.setUpdateByEmail(true);
        System.out.println(client.postSpitterForObject(spitter));
    }

    @Test
    public void testPostSpitterForLocation() {
        Spitter spitter = new Spitter();
        spitter.setId(3L);
        spitter.setUsername("test");
        spitter.setPassword("123456");
        spitter.setFullName("test test");
        spitter.setEmail("123@qq.com");
        spitter.setUpdateByEmail(true);
        System.out.println(client.postSpitterForLocation(spitter));
    }

    @Test
    public void testPostSpitterForExchange() throws IOException {
        Spitter spitter = new Spitter();
        spitter.setId(3L);
        spitter.setUsername("test");
        spitter.setPassword("123456");
        spitter.setFullName("test test");
        spitter.setEmail("123@qq.com");
        spitter.setUpdateByEmail(true);
        System.out.println(client.postSpitterByExchange(spitter));
    }
}
