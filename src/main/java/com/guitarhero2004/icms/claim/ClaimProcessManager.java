package com.guitarhero2004.icms.claim;

import java.util.ArrayList;

public interface ClaimProcessManager {
    void addClaim(Claim claim);
    void updateClaim(Claim claim);
    void deleteClaim(Claim claim);
    void getOneClaim(String id);
    void getAllClaims(ArrayList<Claim> claims);
}
