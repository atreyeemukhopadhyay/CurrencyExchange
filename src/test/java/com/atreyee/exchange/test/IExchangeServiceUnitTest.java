package com.atreyee.exchange.test;

import com.atreyee.exchange.exception.InvalidInputException;
import com.atreyee.exchange.service.IExchangeService;
import com.atreyee.exchange.service.IExchangeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IExchangeServiceUnitTest {
    private IExchangeService exchangeService;

    @Before
    public void setUp() {
        exchangeService = new IExchangeServiceImpl();
    }

    @Test
    public void successScenario(){
        assertNotNull(exchangeService.exchangeValue("EUR/USD", 1.0));
        assertEquals(String.class, exchangeService.exchangeValue("EUR/USD", 1.0).getClass());
        assertEquals("1.11",exchangeService.exchangeValue("EUR/USD", 1.0));
        assertEquals("1.0",exchangeService.exchangeValue("EUR/EUR", 1.0));
    }

    @Test
    public void localeConversion(){
        assertEquals("120.2",exchangeService.exchangeValue("EUR/JPY", 1.0));
        assertEquals("12,020",exchangeService.exchangeValue("EUR/JPY", 100.0));
        assertEquals("7,47",exchangeService.exchangeValue("EUR/DKK", 1.0));
        assertEquals("74.700",exchangeService.exchangeValue("EUR/DKK", 10000.0));
    }
}
