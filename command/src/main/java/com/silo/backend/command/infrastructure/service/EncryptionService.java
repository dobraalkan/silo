package com.silo.backend.command.infrastructure.service;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.StringUtil;

import java.math.BigInteger;
import java.security.MessageDigest;

@Service
public class EncryptionService {

    public String encryptedValue(String aPlainTextValue) {
        if(StringUtil.isNullOrEmpty(aPlainTextValue)){
            throw new IllegalArgumentException("Plain text value to encrypt must be provided.");
        }

        String encryptedValue = null;

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(aPlainTextValue.getBytes("UTF-8"));

            BigInteger bigInt = new BigInteger(1, messageDigest.digest());

            encryptedValue = bigInt.toString(16);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return encryptedValue;
    }
}
