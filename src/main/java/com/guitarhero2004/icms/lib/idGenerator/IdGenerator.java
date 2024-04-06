package com.guitarhero2004.icms.lib.idGenerator;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.util.Random;

/**
 * Class representing an ID generator.
 * This class is used to generate random IDs of a specified length.
 */
public class IdGenerator {
    /**
     * The generated ID.
     */
    private String id;

    /**
     * The characters used to generate the ID.
     */
    private static String numbers = "0123456789";

    /**
     * Private constructor for IdGenerator.
     * @param id The generated ID.
     */
    private IdGenerator(String id) {
        this.id = id;
    }

    /**
     * Generates a random ID of the specified length.
     * @param length The length of the ID to generate.
     * @return An IdGenerator object with the generated ID.
     */
    public static IdGenerator generateId (int length) {
        StringBuilder idBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            idBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return new IdGenerator(idBuilder.toString());
    }

    /**
     * Prefixes the generated ID with the specified prefix.
     * @param prefix The prefix to add to the ID.
     * @return The prefixed ID.
     */
    public String prefix(String prefix) {
        return prefix + id;
    }

    /**
     * Returns a string representation of the IdGenerator object.
     * @return A string representation of the IdGenerator object.
     */
    @Override
    public String toString() {
        return "IdGenerator{" +
                "id='" + id + '\'' +
                '}';
    }

    /**
     * Returns the generated ID.
     * @return The generated ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID.
     * @param id The new ID.
     */
    public void setId(String id) {
        this.id = id;
    }

}