package com.paxport.lookup.airline;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AirlineTests {

    @Test
    public void easyjetTest() throws IOException {

        Optional<String> name = AirlineCodes.airlineName("EZY");
        Assert.assertEquals("easyJet",name.get());

        name = AirlineCodes.airlineName("U2");
        Assert.assertEquals("easyJet",name.get());

    }

    @Test
    public void testNum(){

        List<Airline> all = Airlines.all();
        Assert.assertEquals(6048,all.size());

    }

}
