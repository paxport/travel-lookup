package com.paxport.lookup.airport;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class AirportsTest {

    @Test
    public void heathrowTest(){
        String name = IataAirportCodes.airportName("LHR").get();
        Assert.assertEquals("London Heathrow", name);

        Airport airport = IataAirportCodes.airport("LHR").get();
        Assert.assertEquals(51.4775d, airport.getLatitude(),.01);
        Assert.assertEquals(-0.461389d, airport.getLongitude(),.01);
        Assert.assertEquals("Europe/London", airport.getTimezone());
    }

    @Test
    public void niceTest(){
        String name = IataAirportCodes.airportName("NCE").get();
        Assert.assertEquals("Nice Cote D'Azur", name);
    }

    @Test
    public void bristolTest(){
        String name = IataAirportCodes.airportName("BRS").get();
        Assert.assertEquals("Bristol", name);
    }

    @Test
    public void testNum(){
        List<Airport> all = Airports.all();
        Assert.assertEquals(8105,all.size());
    }
}
