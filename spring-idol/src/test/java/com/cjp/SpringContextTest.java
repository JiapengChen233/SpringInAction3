package com.cjp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-idol-context.xml"
})
public class SpringContextTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void createASimpleBean() {
        Performer duke = (Performer) ctx.getBean("duke");
        assertNotNull(duke);
        duke.perform();
    }

    @Test
    public void injectByConstructor() {
        Performer duke = (Performer) ctx.getBean("duke2");
        assertNotNull(duke);
        duke.perform();
    }

    @Test
    public void injectObjectReferenceByConstructor() {
        Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");
        assertNotNull(poeticDuke);
        poeticDuke.perform();
    }

    @Test
    public void createBeanByFactoryMethod() {
        Stage theStage = (Stage) ctx.getBean("theStage");
        assertNotNull(theStage);
    }

    @Test
    public void definePrototype() {
        Ticket ticket = (Ticket) ctx.getBean("ticket");
        Ticket ticket2 = (Ticket) ctx.getBean("ticket");
        assertNotEquals(ticket, ticket2);
    }

    @Test
    public void executeDefinedMethodsWhenInitAndDestroy() {
        Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");
        assertNotNull(auditorium);
    }

    @Test
    public void injectBeanProperties() {
        Performer performer = (Performer) ctx.getBean("kenny");
        performer.perform();
    }

    @Test
    public void injectInnerBean() {
        Performer performer = (Performer) ctx.getBean("kenny2");
        performer.perform();
    }

    @Test
    public void autowireBeanBySpringP() {
        Performer performer = (Performer) ctx.getBean("kenny3");
        performer.perform();
    }

    @Test
    public void autowireList() {
        Performer performer = (Performer) ctx.getBean("hank");
        performer.perform();
    }

    @Test
    public void autowireSet() {
        Performer performer = (Performer) ctx.getBean("hank2");
        performer.perform();
    }

    @Test
    public void autowireMap() {
        Performer performer = (Performer) ctx.getBean("hank3");
        performer.perform();
    }

    @Test
    public void autowireProperties() {
        Performer performer = (Performer) ctx.getBean("hank4");
        performer.perform();
    }

    @Test
    public void autowireNULL() {
        Artist artist = (Artist) ctx.getBean("artist");
        assertNull(artist.getName());
    }

    @Test
    public void useOtherBeanPropertiesBySpEL() {
        Performer performer = (Performer) ctx.getBean("carl");
        performer.perform();
    }

    @Test
    public void useOtherBeanMethodsBySpEL() {
        Performer performer = (Performer) ctx.getBean("carl2");
        performer.perform();
    }

    @Test
    public void checkNullBySpEL() {
        Performer performer = (Performer) ctx.getBean("carl3");
        performer.perform();
    }

    @Test
    public void useStaticClassBySpEL() {
        Performer performer = (Performer) ctx.getBean("carl4");
        performer.perform();
    }

    @Test
    public void calculateBySpEL() {
        Circle circle = (Circle) ctx.getBean("circle");
        System.out.println("circle's area is: " + circle.getArea());
    }

    @Test
    public void accessCollectionMembersBySpEL() {
        Cities cities = (Cities) ctx.getBean("cityGroup");
        for (City c : cities.getCities()) {
            System.out.println(c);
        }
    }

    @Test
    public void mapBySpEL() {
        Country country = (Country) ctx.getBean("country");
        List<String> cityNames = country.getCityNames();
        System.out.println(cityNames);
    }

    @Test
    public void getValueFromConfig() {
        Book book = (Book) ctx.getBean("book");
        System.out.println("book's name is: " + book.getName());
    }

    @Test
    public void getPropertiesFromConfig() {
        Config config = (Config) ctx.getBean("config");
        Properties systemEnvironment = config.getSystemEnvironment();
        for (Map.Entry entry : systemEnvironment.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        Properties systemProperties = config.getSystemProperties();
        for (Map.Entry entry : systemProperties.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        System.out.println("Path is: " + config.getPath());
    }


}