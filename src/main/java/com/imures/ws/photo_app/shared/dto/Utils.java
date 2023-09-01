package com.imures.ws.photo_app.shared.dto;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new Random();
    private final String ALPHABET = "0123456789QWERTYUIOP[]ASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";

    public String generateRandomUserId(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length){
        StringBuilder returnValue = new StringBuilder(length);

        for(int i = 0; i < length; i++)
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

        return new String(returnValue);
    }
}
