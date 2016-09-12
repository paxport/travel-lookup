package com.paxport.lookup.airport;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


public class AirportsTest {

    @Test
    public void testCodeToNameMap() {
        Map<String,String> map = Airports.iataCodeToNameMap();
        Assert.assertEquals(6017,map.size());
    }
}
