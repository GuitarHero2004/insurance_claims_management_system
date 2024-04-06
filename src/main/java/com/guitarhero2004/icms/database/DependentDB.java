package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

/**
 * Class representing a database for Dependent objects.
 * Extends the AbstractDB class.
 * This class follows the Singleton design pattern.
 */
public class DependentDB extends AbstractDB<Dependent> {

    /**
     * The single instance of the DependentDB class.
     */
    private static DependentDB instance;

    /**
     * Private constructor for DependentDB.
     * Initializes the Gson object with a LocalDateTimeAdapter and loads the data from the JSON file.
     */
    private DependentDB() {
        super(new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                        .create(),
                Dependent.class,
                new TypeToken<Set<Dependent>>() {
                });
    }

    /**
     * Returns the single instance of the DependentDB class.
     * If the instance does not exist, it is created.
     * @return The single instance of the DependentDB class.
     */
    public static DependentDB getInstance() {
        if (instance == null) {
            synchronized (DependentDB.class) {
                if (instance == null) {
                    instance = new DependentDB();
                }
            }
        }
        return instance;
    }

}