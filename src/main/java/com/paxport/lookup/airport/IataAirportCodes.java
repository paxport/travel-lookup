package com.paxport.lookup.airport;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * BY referencing this class it will load the db of codes to airports
 */
public class IataAirportCodes {

    private final static Map<String,Airport> CODE_TO_AIRPORT = buildMap();

    public static Optional<String> airportName(String iataCode) {
        Optional<Airport> airport = airport(iataCode);
        if ( airport.isPresent() ){
            return Optional.ofNullable(airport.get().getCityPlusName());
        }
        return Optional.empty();
    }

    public static Optional<Airport> airport(String iataCode){
        return Optional.ofNullable(CODE_TO_AIRPORT.get(iataCode));
    }

    private static Map<String,Airport> buildMap(){
        return Airports.all().stream()
                .filter(a -> a.hasIataCode())
                .collect(Collectors.toMap(Airport::getIataCode, Function.identity()));
    }

}
