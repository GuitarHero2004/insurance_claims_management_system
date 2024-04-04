package com.guitarhero2004.icms.database;

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

public class AbstractDB<T> {
    protected Set<T> db;

    private TypeToken<Set<T>> objectType;

    private String filePath;

    private String fileName;

    private final String fileExtension = "json";

    private final Gson gson;

    public AbstractDB(Gson gson, Class<T> clazz, TypeToken<Set<T>> objectType) {
        this.gson = gson;
        this.db = loadData(clazz, objectType);
    }

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

    public void add(T object) {
        db.add(object);
    }

    public void delete(T object) {
        db.remove(object);
    }

    public Set<T> getAll() {
        return db;
    }

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

    private String getOutputFile() {
        return String.format("%s.%s", fileName, fileExtension);
    }

}
