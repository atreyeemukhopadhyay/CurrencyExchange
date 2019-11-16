package com.atreyee.exchange.util;

public enum OutputMessage {
    INVALID_CURRENCY("Provided currency is invalid"),
    CURRENCY_PAIR_NOT_PROVIDED("Currency Pair not provided.Please provide currency in maincurrency/moneycurrency format"),
    BLANK_CURRENCY("Either or both the currency is blank"),
    EXCHANGE_RATE_NOT_AVAILABLE("Exchange rate for currency %s is not available in the chart"),
    COMMAND_MESSAGE("Usage: Exchange <currency pair e.g. EUR/USD> <amount to exchange>");

    private String message;

    OutputMessage(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }
}
