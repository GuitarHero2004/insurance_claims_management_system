package com.guitarhero2004.icms.generator;

import java.util.Random;

public class IdGenerator {
    public static String generateRandomId (int length) {
        String idDigits = "0000000001";
        StringBuilder idBuilder = new StringBuilder();

        Random randomId = new Random();

        for (int i = 0; i < length; i++) {
            int index = randomId.nextInt(idDigits.length());
            idBuilder.append(idDigits.charAt(index));
        }
        return idBuilder.toString();
    }
}
