package com.cjp.spitter.client;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RestClientForSpitter {

    /**
     * 检索资源
     */
    public Spittle[] retrieveSpittlesForObject(String username) {
        return new RestTemplate().getForObject("http://localhost:8080/Spitter/rest/spitters/{spitter}/spittles", Spittle[].class, username);
    }

    /**
     * 检索资源
     */
    public Spittle[] retrieveSpittlesForEntity(String username) {
        ResponseEntity<Spittle[]> response = new RestTemplate().getForEntity("http://localhost:8080/Spitter/rest/spitters/{spitter}/spittles", Spittle[].class, username);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    /**
     * 更新资源
     */
    public void updateSpitter(Spitter spitter) throws URISyntaxException {
        String url = "http://localhost:8080/Spitter/rest/spitters/" + spitter.getId();
        new RestTemplate().put(new URI(url), spitter);
    }

    /**
     * 删除资源
     */
    public void deleteSpittle(long id) throws URISyntaxException {
        new RestTemplate().delete(new URI("http://localhost:8080/Spitter/rest/spitters/spittles/" + id));
    }

    /**
     * 创建资源
     */
    public Spitter postSpitterForObject(Spitter spitter) {
        return new RestTemplate().postForObject("http://localhost:8080/Spitter/rest/spitters/", spitter, Spitter.class);
    }

    /**
     * 创建资源
     */
    public String postSpitterForLocation(Spitter spitter) {
        return new RestTemplate().postForLocation("http://localhost:8080/Spitter/rest/spitters/", spitter).toString();
    }

    /**
     * 创建资源
     */
    public Spitter postSpitterByExchange(Spitter spitter) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(spitter);
        HttpEntity<String> entity = new HttpEntity<>(jsonStr, headers);
        ResponseEntity<Spitter> response = new RestTemplate().exchange("http://localhost:8080/Spitter/rest/spitters/", HttpMethod.POST, entity, Spitter.class);
        return response.getBody();
    }
}