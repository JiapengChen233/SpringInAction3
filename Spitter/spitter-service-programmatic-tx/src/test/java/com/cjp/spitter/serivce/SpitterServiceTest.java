package com.cjp.spitter.serivce;

import org.junit.Before;
import org.junit.Test;
import com.cjp.spitter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.service.SpitterServiceImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import static org.easymock.EasyMock.*;

public class SpitterServiceTest {

    private SpitterServiceImpl spitterService;
    private SpitterDao spitterDao;
    private Spitter newSpitter;
    private Spitter oldSpitter;

    @Before
    public void setup() {
        newSpitter = new Spitter();
        newSpitter.setUsername("testuser");
        newSpitter.setPassword("password");
        newSpitter.setFullName("Michael McTest");

        oldSpitter = new Spitter();
        oldSpitter.setId(12345L);
        oldSpitter.setUsername("olduser");
        oldSpitter.setPassword("letmein");
        oldSpitter.setFullName("Bob O'Test");

        spitterDao = createNiceMock(SpitterDao.class);
        spitterDao.saveSpitter(oldSpitter);
        spitterDao.addSpitter(newSpitter);

        replay(spitterDao);

        spitterService = new SpitterServiceImpl();
        spitterService.setSpitterDao(spitterDao);
        PlatformTransactionManager txMgr = new FakeTransactionManager();
        TransactionTemplate txTemplate = new TransactionTemplate(txMgr);
        spitterService.setTxTemplate(txTemplate);
    }

    @Test
    public void shouldAddSpitter() {
        spitterService.saveSpitter(newSpitter);
        spitterService.saveSpitter(oldSpitter);
        verify(spitterDao);
    }
}
