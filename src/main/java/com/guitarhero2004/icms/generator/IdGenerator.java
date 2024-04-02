package com.guitarhero2004.icms.generator;

import java.util.Random;

public class IdGenerator {
    public static String generateCustomerId () {
        String prefix = "c-";
        int length = 7;
        String customerIdDigits = "0000001";
        StringBuilder customerIdBuilder = new StringBuilder();

        Random randomCustomerId = new Random();

        customerIdBuilder.append(prefix);

        for (int i = 0; i < length; i++) {
            int index = randomCustomerId.nextInt(customerIdDigits.length());
            customerIdBuilder.append(customerIdDigits.charAt(index));
        }
        return customerIdBuilder.toString();
    }


    public static String generateInsuranceCardId () {
        String prefix = "f-";
        int length = 10;
        String insuranceCardIdDigits = "0000000001";
        StringBuilder insuranceCardIdBuilder = new StringBuilder();

        Random randomInsuranceCardId = new Random();

        insuranceCardIdBuilder.append(prefix);

        for (int i = 0; i < length; i++) {
            int index = randomInsuranceCardId.nextInt(insuranceCardIdDigits.length());
            insuranceCardIdBuilder.append(insuranceCardIdDigits.charAt(index));
        }
        return insuranceCardIdBuilder.toString();
    }

}
