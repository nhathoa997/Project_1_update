package com.ex.tests.service;

import com.ex.app.services.PricingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PricingServiceTests {
    PricingService service;

    @Before
    public void init(){
        service = new PricingService();
    }

    @Test
    public void serviceShouldNotBeNull(){
        Assert.assertNotNull("Service instance not created", service);
    }

    @Test
    public void shouldReturn0For0Items(){
        float cost = service.compute(0,10.00f, "FL", new String[]{});
        Assert.assertEquals("Cost not calculated as 0.0", 0.0f, cost, 0.0f);
    }
}
