package com.guitarhero2004.icms.database;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Abstract class representing a database.
 * This class is generic and can be used with any type that needs to be stored in a database.
 * The data is stored in a Set and is saved to a JSON file when the program is shut down.
 */
public class AbstractDB<T> {
    protected Set<T> db;

    private TypeToken<Set<T>> objectType;

    private String filePath;

    private String fileName;

    private final String fileExtension = "json";

    private final Gson gson;

    /**
     * Constructor for AbstractDB.
     * @param gson The Gson object used for JSON serialization and deserialization.
     * @param clazz The class of the objects that will be stored in the database.
     * @param objectType The TypeToken of the Set of objects that will be stored in the database.
     */
    public AbstractDB(Gson gson, Class<T> clazz, TypeToken<Set<T>> objectType) {
        this.gson = gson;
        this.db = loadData(clazz, objectType);
    }

    /**
     * Loads the data from the JSON file into the Set.
     * @param clazz The class of the objects that will be stored in the database.
     * @param objectType The TypeToken of the Set of objects that will be stored in the database.
     * @return The Set of objects loaded from the JSON file.
     */
    private Set<T> loadData(Class<T> clazz, TypeToken<Set<T>> objectType) {
        this.fileName = clazz.getSimpleName();

        // create a Type object for the data type
        this.objectType = objectType;

        // Save on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> saveData()));

        // Load data from file
        try {
            // Create folder if not exist
            File dataFolder = new File("./data");
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            this.filePath = String.format("./data/%s", getOutputFile());
            File dataFile = new File(this.filePath);
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }

            // Load
            Path path = Paths.get(this.filePath);

            String json = Files.readString(path);

            Set<T> db = gson.fromJson(json, objectType);
            if (db != null) {
                return db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashSet<T>();

    }

    /**
     * Adds an object to the Set.
     * @param object The object to add.
     */
    public void add(T object) {
        db.add(object);
    }

    /**
     * Deletes an object from the Set.
     * @param object The object to delete.
     */
    public void delete(T object) {
        db.remove(object);
    }

    /**
     * Returns all objects in the Set.
     * @return All objects in the Set.
     */
    public Set<T> getAll() {
        return db;
    }

    /**
     * Saves the Set of objects to the JSON file.
     */
    private void saveData() {
        String json = gson.toJson(db, objectType.getType());

        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(json);

            bufferedWriter.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns the name of the output file.
     * @return The name of the output file.
     */
    private String getOutputFile() {
        return String.format("%s.%s", fileName, fileExtension);
    }

}