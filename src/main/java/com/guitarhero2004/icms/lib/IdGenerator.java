package com.guitarhero2004.icms.lib;

import java.util.Random;

public class IdGenerator {

    private String id;

    private static String numbers = "0123456789";

    private IdGenerator(String id) {
        this.id = id;
    }

    public static IdGenerator generateId (int length) {
        StringBuilder idBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            idBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return new IdGenerator(idBuilder.toString());
    }

    public String prefix(String prefix) {
        return prefix + id;
    }

    @Override
    public String toString() {
        return "IdGenerator{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
