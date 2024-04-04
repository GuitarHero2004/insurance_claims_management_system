package com.guitarhero2004.icms.database;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

public class DependentDB extends AbstractDB<Dependent> {

    private static DependentDB instance;

    private DependentDB() {
        super(new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create(),
                Dependent.class,
                new TypeToken<Set<Dependent>>() {});
    }

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
