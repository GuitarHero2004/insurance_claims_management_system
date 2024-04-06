package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.customer.PolicyHolder;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

/**
 * Class representing a database for PolicyHolder objects.
 * Extends the AbstractDB class.
 * This class follows the Singleton design pattern.
 */
public class PolicyHolderDB extends AbstractDB<PolicyHolder> {

    /**
     * The single instance of the PolicyHolderDB class.
     */
    private static PolicyHolderDB instance;

    /**
     * Private constructor for PolicyHolderDB.
     * Initializes the Gson object with a LocalDateTimeAdapter and loads the data from the JSON file.
     */
    private PolicyHolderDB() {
        super(new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                        .create(),
                PolicyHolder.class,
                new TypeToken<Set<PolicyHolder>>() {
                });
    }

    /**
     * Returns the single instance of the PolicyHolderDB class.
     * If the instance does not exist, it is created.
     * @return The single instance of the PolicyHolderDB class.
     */
    public static PolicyHolderDB getInstance() {
        if (instance == null) {
            synchronized (DependentDB.class) {
                if (instance == null) {
                    instance = new PolicyHolderDB();
                }
            }
        }
        return instance;
    }
}