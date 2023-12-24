package com.silo.backend.service.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class PasswordService {

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyPassword(String givenPassword, String hashedPassword) {
        return BCrypt.checkpw(givenPassword, hashedPassword);
    }
}
