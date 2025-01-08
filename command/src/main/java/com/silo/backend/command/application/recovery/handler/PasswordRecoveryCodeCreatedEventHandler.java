package com.silo.backend.command.application.recovery.handler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//import com.silo.backend.command.application.recovery.command.SendPasswordRecoveryEmailCommand;
//import com.silo.backend.command.domain.model.event.DomainEventPublisher;
//import com.silo.backend.command.domain.model.event.DomainEventSubscriber;
//import com.silo.backend.command.domain.model.event.PasswordRecoveryCodeCreated;
//import com.silo.backend.command.infrastructure.base.AuthenticationModule;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class PasswordRecoveryCodeCreatedEventHandler {

    //private final String recoveryLink;

    @Before("execution(" +
                    "public * com.tomo.mcauthentication.application.configuration.CommandHandler.*(..)) && " +
                    "target(com.tomo.mcauthentication.application.recovery.CreatePasswordRecoveryCodeCommandHandler))")
    public void listen() {
/*         DomainEventPublisher
            .instance()
            .subscribe(new DomainEventSubscriber<PasswordRecoveryCodeCreated>() {

                public void handleEvent(PasswordRecoveryCodeCreated aDomainEvent) {
                    module.executeCommand(new SendPasswordRecoveryEmailCommand(
                            aDomainEvent.getEmail(),
                            aDomainEvent.getRecoveryCode(),
                            recoveryLink,
                            aDomainEvent.getRecoveryCodeExpirationDate()));
                }

                public Class<PasswordRecoveryCodeCreated> subscribedToEventType() {
                    return PasswordRecoveryCodeCreated.class;
                }
            }); */
    }
}
