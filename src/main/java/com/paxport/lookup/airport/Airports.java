package com.paxport.lookup.airport;


import com.fasterxml.jackson.core.type.TypeReference;
import com.paxport.lookup.json.JsonUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Airports {

    private final static String AIRPORTS_RESOURCE = "airports.json";

    public static InputStream jsonAirports() {
        return Airports.class.getClassLoader().getResourceAsStream(AIRPORTS_RESOURCE);
    }

    public static List<AirportData> all() {
        return JsonUtils.fromJson(jsonAirports(),new TypeReference<List<AirportData>>(){});
    }

    public static List<AirportData> airports() {
        return all().stream()
                .filter(a -> a.getType() == AirportData.Type.airport)
                .filter(a -> a.getName() != null)
                .collect(Collectors.toList());
    }

    public static Map<String,String> iataCodeToNameMap(){
        return all().stream()
                .filter(a -> a.getType() == AirportData.Type.airport)
                .filter(a -> a.getIata() != null)
                .filter(a -> a.getName() != null)
                .collect(Collectors.toMap(
                        AirportData::getIata, AirportData::getName,
                        (one, two) -> one // take first in db if duplicate
                ));
    }

}
