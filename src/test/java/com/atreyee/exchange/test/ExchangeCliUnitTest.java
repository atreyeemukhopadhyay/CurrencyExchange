package com.atreyee.exchange.test;

import com.atreyee.exchange.command.ExchangeCli;
import com.atreyee.exchange.service.IExchangeService;
import com.atreyee.exchange.service.IExchangeServiceImpl;
import com.atreyee.exchange.util.OutputMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExchangeCliUnitTest {
    private ExchangeCli exchangeCli;

    private IExchangeService IExchangeService;

    @Before
    public void setUp(){
        IExchangeService = new IExchangeServiceImpl();
        exchangeCli = new ExchangeCli(IExchangeService);
    }

    @Test
    public void PositiveScenario(){
     assertNotNull(exchangeCli.exchange("EUR/USD",1.0));
     assertEquals(exchangeCli.exchange("EUR/USD",1.0).getClass(), String.class);
     assertEquals("1.11",exchangeCli.exchange("EUR/USD",1.0));
     assertEquals("1.0",exchangeCli.exchange("EUR/EUR",1.0));
    }

    @Test
    public void blankMoneyCurrency() {
        assertEquals(exchangeCli.exchange("EUR/",1.0), OutputMessage.BLANK_CURRENCY.getMessage());
    }

    @Test
    public void blankCurrency(){
        assertEquals(exchangeCli.exchange("/",1.0), OutputMessage.BLANK_CURRENCY.getMessage());
    }

    @Test
    public void invalidFormatCurrency() {
        assertEquals(exchangeCli.exchange("EURUSD",1.0),OutputMessage.CURRENCY_PAIR_NOT_PROVIDED.getMessage());
    }

    @Test
    public void invalidMainCurrency() {
        assertEquals(exchangeCli.exchange("ABC/BBC",1.0),OutputMessage.INVALID_CURRENCY.getMessage());
    }
}
