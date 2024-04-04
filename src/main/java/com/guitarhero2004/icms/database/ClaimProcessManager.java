package com.guitarhero2004.icms.database;

import java.util.Collection;

import com.guitarhero2004.icms.claim.Claim;

public interface ClaimProcessManager {
    void add(Claim object);
    void update(Claim object);
    void delete(Claim object);
    Claim getOne(String key);
    Collection<Claim> getAll();
}
