package com.guitarhero2004.icms.database;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.customer.PolicyHolder;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

public class PolicyHolderDB extends AbstractDB<PolicyHolder> {

    private static PolicyHolderDB instance;

    private PolicyHolderDB() {
        super(new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create(),
                PolicyHolder.class,
                new TypeToken<Set<PolicyHolder>>() {
                });
    }

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
