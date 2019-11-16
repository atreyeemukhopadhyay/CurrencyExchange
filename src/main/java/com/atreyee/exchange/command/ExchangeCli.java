package com.atreyee.exchange.command;

import com.atreyee.exchange.service.IExchangeService;
import com.atreyee.exchange.util.OutputMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ExchangeCli {
    private final IExchangeService exchangeService;

    Logger log = LoggerFactory.getLogger(ExchangeCli.class);

    @Autowired
    public ExchangeCli(IExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @ShellMethod("This command is used for currency exchange")
    public String exchange(@ShellOption(defaultValue = "") String currencyPair, @ShellOption(defaultValue = "0.0") Double amount) {
        String output = OutputMessage.COMMAND_MESSAGE.getMessage();

        log.debug("Input values currency {} amount {}",currencyPair,amount);

        if (!currencyPair.equals("") && !amount.equals(0.0)) {
            try {
                output = exchangeService.exchangeValue(currencyPair, amount);
            } catch (RuntimeException ex) {
                log.error(ex.getMessage());
                output = ex.getMessage();
            }
        }

        return output;
    }
}
