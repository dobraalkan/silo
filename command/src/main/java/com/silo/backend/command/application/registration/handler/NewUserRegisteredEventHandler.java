package com.silo.backend.command.application.registration.handler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//import com.silo.backend.command.application.registration.command.SendRegistrationConfirmationEmailCommand;
//import com.silo.backend.command.domain.model.event.DomainEventPublisher;
//import com.silo.backend.command.domain.model.event.DomainEventSubscriber;
//import com.silo.backend.command.domain.model.event.UserRegistrationRequested;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class NewUserRegisteredEventHandler {

    /**
     * In order to not mix business logic with plugins like a GUI..
     * baseUrl + URI + queryString eg. localhost/register/confirm/?confirmationCode=
     */
    //private final String confirmationLink;

    @Before(value = "execution(public * com.tomo.mcauthentication.application.configuration.AbstractVoidyCommandHandler.*(..)) && target(com.tomo.mcauthentication.application.registration.RegisterNewUserCommandHandler))")
    public void listen() {
/*         DomainEventPublisher
                .instance()
                .subscribe(new DomainEventSubscriber<UserRegistrationRequested>() {

                    public void handleEvent(UserRegistrationRequested aDomainEvent) {
                        authenticationModule.executeCommand(new SendRegistrationConfirmationEmailCommand(
                                aDomainEvent.getEmail(),
                                confirmationLink,
                                aDomainEvent.getConfirmationCode()));
                    }

                    public Class<UserRegistrationRequested> subscribedToEventType() {
                        return UserRegistrationRequested.class; // all domain events
                    }
                }); */
    }
}
