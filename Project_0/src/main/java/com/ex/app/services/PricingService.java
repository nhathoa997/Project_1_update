package com.ex.app.services;

public class PricingService {
    public float compute(int itemCount, float basePrice, String stateCode, String[] couponCodes){
        if(itemCount == 0) return 0f;
        return -1f;
    }

}
