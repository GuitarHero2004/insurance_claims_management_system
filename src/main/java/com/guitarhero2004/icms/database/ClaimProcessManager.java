package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.util.Collection;

import com.guitarhero2004.icms.claim.Claim;

/**
 * Interface for managing the process of Claims.
 * This interface defines the methods that need to be implemented for managing Claims.
 */
public interface ClaimProcessManager {

    /**
     * Adds a Claim object.
     * @param object The Claim object to add.
     */
    void add(Claim object);

    /**
     * Updates a Claim object.
     * @param oldObject The old Claim object.
     * @param newObject The new Claim object.
     */
    void update(Claim oldObject, Claim newObject);

    /**
     * Deletes a Claim object.
     * @param object The Claim object to delete.
     */
    void delete(Claim object);

    /**
     * Returns a Claim object.
     * @param key The key of the Claim object to return.
     * @return The Claim object.
     */
    Claim getOne(String key);

    /**
     * Returns all Claim objects.
     * @return A collection of all Claim objects.
     */
    Collection<Claim> getAll();
}