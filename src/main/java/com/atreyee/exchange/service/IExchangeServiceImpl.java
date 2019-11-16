package com.atreyee.exchange.service;

import com.atreyee.exchange.util.CurrencyRate;
import com.atreyee.exchange.util.LocaleDetails;
import com.atreyee.exchange.util.OutputMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Component
public class IExchangeServiceImpl implements IExchangeService {

    private Logger log = LoggerFactory.getLogger(IExchangeServiceImpl.class);

    @Override
    public String exchangeValue(String currencyPair, Double amount) {
        String exchangeValue;
        String mainCurrency;
        String moneyCurrency;

        //Check if currency is provided in correct format
        if (!currencyPair.contains("/")) {
            return OutputMessage.CURRENCY_PAIR_NOT_PROVIDED.getMessage();
        }

        String[] currencyList = currencyPair.split("/");
        if (currencyList.length < 2 || currencyList[0].equals("") || currencyList[1].equals("")) {
            return OutputMessage.BLANK_CURRENCY.getMessage();
        } else {
            mainCurrency = currencyList[0];
            moneyCurrency = currencyList[1];

            log.debug("main currency {} , money currency {}",mainCurrency,moneyCurrency);
        }

        if (CurrencyRate.isValidCurrency(mainCurrency) && CurrencyRate.isValidCurrency(moneyCurrency)) {
            if (mainCurrency.equalsIgnoreCase(moneyCurrency)) {
                exchangeValue = amount.toString();
            } else {
                BigDecimal exchangeRate = CurrencyRate.getExchangeRate(mainCurrency, moneyCurrency);
                if (exchangeRate != null) {
                    NumberFormat numberFormat = NumberFormat.getInstance(LocaleDetails.getLocale(moneyCurrency));
                    exchangeValue = numberFormat.format(CurrencyRate.convert(new BigDecimal(amount), exchangeRate));
                } else {
                    return String.format(OutputMessage.EXCHANGE_RATE_NOT_AVAILABLE.getMessage(), moneyCurrency);
                }
            }
        } else {
            return OutputMessage.INVALID_CURRENCY.getMessage();
        }
        return exchangeValue;
    }
}

