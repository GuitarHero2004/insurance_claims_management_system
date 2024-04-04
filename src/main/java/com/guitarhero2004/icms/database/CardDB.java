package com.guitarhero2004.icms.database;

import java.time.LocalDateTime;
import java.util.Set;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.lib.adapter.LocalDateTimeAdapter;

public class CardDB extends AbstractDB<InsuranceCard> {
    private static CardDB instance;

    private CardDB() {
        super(new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create(),
                InsuranceCard.class,
                new TypeToken<Set<InsuranceCard>>() {});
    }

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
