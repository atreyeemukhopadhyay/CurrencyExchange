package com.atreyee.exchange.test;

import static org.springframework.util.ReflectionUtils.invokeMethod;
import javax.validation.constraints.NotNull;
import org.springframework.shell.CommandRegistry;
import org.springframework.shell.MethodTarget;

public class BaseExchangeCommand {
        protected <T> T invoke(final MethodTarget methodTarget, final Object... args) {
            return (T) invokeMethod(methodTarget.getMethod(), methodTarget.getBean(), args);
        }

        protected MethodTarget lookupCommand(@NotNull final CommandRegistry registry,
                                             @NotNull final String command) {
            return registry.listCommands().get(command);
        }
}
