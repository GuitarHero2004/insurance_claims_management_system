package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

/**
 * Class representing a database for InsuranceCard objects.
 * Extends the AbstractDB class.
 * This class follows the Singleton design pattern.
 */
public class CardDB extends AbstractDB<InsuranceCard> {
    private static CardDB instance;

    /**
     * Private constructor for CardDB.
     * Initializes the Gson object with a LocalDateTimeAdapter and loads the data from the JSON file.
     */
    private CardDB() {
        super(new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                        .create(),
                InsuranceCard.class,
                new TypeToken<Set<InsuranceCard>>() {});
    }

    /**
     * Returns the single instance of the CardDB class.
     * If the instance does not exist, it is created.
     * @return The single instance of the CardDB class.
     */
    public static CardDB getInstance() {
        if (instance == null) {
            synchronized (DependentDB.class) {
                if (instance == null) {
                    instance = new CardDB();
                }
            }
        }
        return instance;
    }

}