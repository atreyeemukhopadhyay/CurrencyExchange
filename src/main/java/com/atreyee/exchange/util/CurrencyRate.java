package com.atreyee.exchange.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyRate {

    private static Logger log = LoggerFactory.getLogger(CurrencyRate.class);

    private CurrencyRate() {

    }

    private static Map<String, HashMap<String, Double>> currencyConversionRates;

    private static final String CURRENCY_CODE_EURO = "EUR";
    private static final String CURRENCY_CODE_AMERICAN_DOLLAR = "USD";
    private static final String CURRENCY_CODE_BRITISH_POUND = "GBP";
    private static final String CURRENCY_CODE_SVENSKE_KRONER = "SEK";
    private static final String CURRENCY_CODE_NORSKE_KRONER = "NOK";
    private static final String CURRENCY_CODE_DANSKE_KRONER = "DKK";
    private static final String CURRENCY_CODE_SCHWEIZISKE_FRANC = "CHF";
    private static final String CURRENCY_CODE_JAPANSKE_YEN = "JPY";

    static {
        loadCurrencyValues();
    }

    private static void loadCurrencyValues() {

        currencyConversionRates = new HashMap<>();

        //rates wrt euro
        HashMap<String, Double> euroRates = new HashMap<>();
        euroRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 1.11);
        euroRates.put(CURRENCY_CODE_BRITISH_POUND, 0.86);
        euroRates.put(CURRENCY_CODE_SVENSKE_KRONER, 10.66);
        euroRates.put(CURRENCY_CODE_NORSKE_KRONER, 10.04);
        euroRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 1.09);
        euroRates.put(CURRENCY_CODE_JAPANSKE_YEN, 120.20);
        euroRates.put(CURRENCY_CODE_DANSKE_KRONER, 7.47);

        currencyConversionRates.put(CURRENCY_CODE_EURO, euroRates);

        //rates wrt dollar
        HashMap<String, Double> usDollarRates = new HashMap<>();

        usDollarRates.put(CURRENCY_CODE_EURO, 0.90);
        usDollarRates.put(CURRENCY_CODE_BRITISH_POUND, 0.77);
        usDollarRates.put(CURRENCY_CODE_SVENSKE_KRONER, 9.65);
        usDollarRates.put(CURRENCY_CODE_NORSKE_KRONER, 9.09);
        usDollarRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 0.99);
        usDollarRates.put(CURRENCY_CODE_JAPANSKE_YEN, 108.77);
        usDollarRates.put(CURRENCY_CODE_DANSKE_KRONER, 6.76);

        currencyConversionRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, usDollarRates);

        //rates wrt DKK
        HashMap<String, Double> dkkRates = new HashMap<>();
        dkkRates.put(CURRENCY_CODE_EURO, 0.13);
        dkkRates.put(CURRENCY_CODE_BRITISH_POUND, 0.11);
        dkkRates.put(CURRENCY_CODE_SVENSKE_KRONER, 1.43);
        dkkRates.put(CURRENCY_CODE_NORSKE_KRONER, 1.34);
        dkkRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 0.15);
        dkkRates.put(CURRENCY_CODE_JAPANSKE_YEN, 16.09);
        dkkRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 0.15);

        currencyConversionRates.put(CURRENCY_CODE_DANSKE_KRONER, dkkRates);


        //rates wrt GBP
        HashMap<String, Double> gbpRates = new HashMap<>();
        gbpRates.put(CURRENCY_CODE_EURO, 1.17);
        gbpRates.put(CURRENCY_CODE_DANSKE_KRONER, 8.73);
        gbpRates.put(CURRENCY_CODE_SVENSKE_KRONER, 12.45);
        gbpRates.put(CURRENCY_CODE_NORSKE_KRONER, 11.73);
        gbpRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 1.28);
        gbpRates.put(CURRENCY_CODE_JAPANSKE_YEN, 139.95);
        gbpRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 1.29);

        currencyConversionRates.put(CURRENCY_CODE_BRITISH_POUND, gbpRates);

        //rates wrt SEK
        HashMap<String, Double> sekRates = new HashMap<>();
        sekRates.put(CURRENCY_CODE_EURO, 0.094);
        sekRates.put(CURRENCY_CODE_DANSKE_KRONER, 0.70);
        sekRates.put(CURRENCY_CODE_BRITISH_POUND, 0.080);
        sekRates.put(CURRENCY_CODE_NORSKE_KRONER, 0.94);
        sekRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 0.10);
        sekRates.put(CURRENCY_CODE_JAPANSKE_YEN, 11.27);
        sekRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 0.10);

        currencyConversionRates.put(CURRENCY_CODE_SVENSKE_KRONER, sekRates);

        //rates wrt NOK
        HashMap<String, Double> nokRates = new HashMap<>();
        nokRates.put(CURRENCY_CODE_EURO, 1.17);
        nokRates.put(CURRENCY_CODE_DANSKE_KRONER, 0.74);
        nokRates.put(CURRENCY_CODE_SVENSKE_KRONER, 1.06);
        nokRates.put(CURRENCY_CODE_BRITISH_POUND, 0.085);
        nokRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 0.11);
        nokRates.put(CURRENCY_CODE_JAPANSKE_YEN, 11.98);
        nokRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 0.11);

        currencyConversionRates.put(CURRENCY_CODE_NORSKE_KRONER, nokRates);

        //rates wrt CHF
        HashMap<String, Double> chfRates = new HashMap<>();
        chfRates.put(CURRENCY_CODE_EURO, 0.91);
        chfRates.put(CURRENCY_CODE_DANSKE_KRONER, 6.83);
        chfRates.put(CURRENCY_CODE_SVENSKE_KRONER, 9.75);
        chfRates.put(CURRENCY_CODE_NORSKE_KRONER, 9.19);
        chfRates.put(CURRENCY_CODE_BRITISH_POUND, 0.78);
        chfRates.put(CURRENCY_CODE_JAPANSKE_YEN, 109.87);
        chfRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 1.01);

        currencyConversionRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, chfRates);

        //rates wrt JPY
        HashMap<String, Double> jpyRates = new HashMap<>();
        jpyRates.put(CURRENCY_CODE_EURO, 0.0083);
        jpyRates.put(CURRENCY_CODE_DANSKE_KRONER, 0.062);
        jpyRates.put(CURRENCY_CODE_SVENSKE_KRONER, 0.089);
        jpyRates.put(CURRENCY_CODE_NORSKE_KRONER, 0.084);
        jpyRates.put(CURRENCY_CODE_SCHWEIZISKE_FRANC, 0.0091);
        jpyRates.put(CURRENCY_CODE_BRITISH_POUND, 0.0071);
        jpyRates.put(CURRENCY_CODE_AMERICAN_DOLLAR, 0.0092);

        currencyConversionRates.put(CURRENCY_CODE_JAPANSKE_YEN, jpyRates);

    }

    // Convert a currency to another
    public static BigDecimal convert(BigDecimal amount, BigDecimal exchangeValue) {
        return amount.multiply(exchangeValue);
    }

    //check if provided currency available in the list
    public static boolean isValidCurrency(String currency) {
        return currencyConversionRates.containsKey(currency);
    }

    public static BigDecimal getExchangeRate(String mainCurrency, String moneyCurrency) {
        Double exchangeRate = currencyConversionRates.get(mainCurrency).get(moneyCurrency);

        log.debug("exchange rate {} for the currency pair {}/{}", exchangeRate, mainCurrency, moneyCurrency);

        if (exchangeRate != null) {
            return new BigDecimal(exchangeRate);
        }
        return null;
    }

}
