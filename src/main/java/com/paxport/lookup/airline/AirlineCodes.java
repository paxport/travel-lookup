package com.paxport.lookup.airline;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AirlineCodes {

    private final static Map<String,String> CODE_TO_NAME = buildMap();

    public static Optional<String> airlineName(String code){
        return Optional.ofNullable(CODE_TO_NAME.get(code));
    }

    private static Map<String,String> buildMap(){
        Map<String,String> map = new HashMap<>();
        for (Airline airline : Airlines.all()) {
            if ( airline.isActive() ){
                if ( airline.getIataCode().isPresent() ){
                    map.put(airline.getIataCode().get(),airline.getName());
                }
                if ( airline.getIcaoCode().isPresent() ){
                    map.put(airline.getIcaoCode().get(),airline.getName());
                }
            }
        }
        return map;
    }
}
