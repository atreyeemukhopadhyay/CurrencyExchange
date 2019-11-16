package com.atreyee.exchange.test;

import com.atreyee.exchange.command.ExchangeCli;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.util.ReflectionUtils.findMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties={InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED+"="+false})

public class ExchangeCommandsTest  extends  BaseExchangeCommand{

    private static final Class<ExchangeCli> commandClass = ExchangeCli.class;

    @Autowired
    private Shell shell;

    @Test
    public void testExchangeCommand(){
        final String command = "exchange";
        final String commandMethod = "exchange";

        final MethodTarget commandTarget = lookupCommand(shell, command);
        assertNotNull(commandTarget);
        assertEquals("This command is used for currency exchange",commandTarget.getHelp());
        assertEquals(commandTarget.getMethod(),
                findMethod(commandClass, commandMethod, String.class, Double.class));
        assertEquals("11.1", invoke(commandTarget,"EUR/USD",10.0));
        assertEquals("11.1",shell.evaluate(() -> command + " EUR/USD 10"));
    }

    @Test(expected = RuntimeException.class)
    public void testExchangeCommandInvalidInput(){
        final String command = "exchange";
        final MethodTarget commandTarget = lookupCommand(shell, command);

        invoke(commandTarget,"EUR/USD","abcd");
    }
}
