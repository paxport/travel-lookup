package com.paxport.lookup.airport;

import java.util.Map;

/**
 * BY referencing this class it will load the db of codes to names
 */
public class IataAirportCodes {

    private final static Map<String,String> CODE_TO_NAME = Airports.iataCodeToNameMap();

    public static String airportName(String iataCode) {
        return CODE_TO_NAME.get(iataCode);
    }

}
