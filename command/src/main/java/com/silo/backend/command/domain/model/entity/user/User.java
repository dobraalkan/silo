package com.silo.backend.command.domain.model.entity.user;

import java.util.UUID;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    public enum AuthProvider {
        EMAIL,
        FACEBOOK,
        GOOGLE
    }

    @EmbeddedId
    UUID userId;
    String firstName;
    String lastName;
    String email;

    @Enumerated(EnumType.STRING)
    AuthProvider provider;

    public User(
            UUID anId,
            String aFirstName,
            String aLastName,
            String anEmail,
            AuthProvider aProvider) {
        //this.checkRule(DomainRegistry.userEmailMustBeUnique(anEmail));
        this.userId = anId;
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.email = anEmail;
        this.provider = aProvider;

        // this.publish(new UserCreated(
        //         this.getUserId(),
        //         this.getFirstName(),
        //         this.getLastName(),
        //         this.getEmail(),
        //         this.getProvider()
        // ));
    }

    public void updateDetails(String aFirstName, String aLastName) {
        this.setFirstName(aFirstName);
        this.setLastName(aLastName);

        // publish(new UserNameChanged(
        //         this.getEmail(),
        //         this.getFirstName(),
        //         this.getLastName()));
    }

    public void setLastName(String aLastName) {
        //assertArgumentNotEmpty(lastName, "Last name cannot be empty.");
        this.lastName = aLastName;
    }

    public void setFirstName(String aFirstName) {
        //assertArgumentNotEmpty(aFirstName, "First name cannot be empty.");
        this.firstName = aFirstName;
    }

}
