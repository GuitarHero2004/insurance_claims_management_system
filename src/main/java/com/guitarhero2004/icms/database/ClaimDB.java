package com.guitarhero2004.icms.database;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

public class ClaimDB extends AbstractDB<Claim> implements ClaimProcessManager{

    public ClaimDB() {
        super(new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create(),
                Claim.class,
                new TypeToken<Set<Claim>>() {
                });
    }

    @Override
    public void update(Claim object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Claim getOne(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }
    
}
