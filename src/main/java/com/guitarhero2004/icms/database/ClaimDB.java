package com.guitarhero2004.icms.database;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

public class ClaimDB extends AbstractDB<Claim> implements ClaimProcessManager{

    private static ClaimDB instance;

    public ClaimDB() {
        super(new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create(),
                Claim.class,
                new TypeToken<Set<Claim>>() {
                });
    }

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

    @Override
    public void update(Claim oldObject, Claim newObject) {
        if (db.contains(oldObject)) {
            db.remove(oldObject);
            db.add(newObject);
        }
    }

    @Override
    public Claim getOne(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }
    
}
