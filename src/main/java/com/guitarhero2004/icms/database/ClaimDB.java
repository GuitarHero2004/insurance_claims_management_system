package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

/**
 * Class representing a database for Claim objects.
 * Extends the AbstractDB class and implements the ClaimProcessManager interface.
 * This class follows the Singleton design pattern.
 */
public class ClaimDB extends AbstractDB<Claim> implements ClaimProcessManager{

    /**
     * The single instance of the ClaimDB class.
     */
    private static ClaimDB instance;

    /**
     * Constructor for ClaimDB.
     * Initializes the Gson object with a LocalDateTimeAdapter and loads the data from the JSON file.
     */
    public ClaimDB() {
        super(new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                        .create(),
                Claim.class,
                new TypeToken<Set<Claim>>() {
                });
    }

    /**
     * Returns the single instance of the ClaimDB class.
     * If the instance does not exist, it is created.
     * @return The single instance of the ClaimDB class.
     */
    public static ClaimDB getInstance() {
        if (instance == null) {
            synchronized (ClaimDB.class) {
                if (instance == null) {
                    instance = new ClaimDB();
                }
            }
        }
        return instance;
    }

    /**
     * Updates a Claim object in the database.
     * If the old object exists in the database, it is removed and the new object is added.
     * @param oldObject The old Claim object.
     * @param newObject The new Claim object.
     */
    @Override
    public void update(Claim oldObject, Claim newObject) {
        if (db.contains(oldObject)) {
            db.remove(oldObject);
            db.add(newObject);
        }
    }

    /**
     * Returns a Claim object from the database.
     * This method is not implemented and throws an UnsupportedOperationException when called.
     * @param key The key of the Claim object to return.
     * @return The Claim object.
     * @throws UnsupportedOperationException If the method is called.
     */
    @Override
    public Claim getOne(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

}