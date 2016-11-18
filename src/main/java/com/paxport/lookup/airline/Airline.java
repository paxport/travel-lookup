package com.paxport.lookup.airline;

import java.util.Optional;

/**
 *
 * Airline ID	Unique OpenFlights identifier for this airline.
 Name	Name of the airline.
 Alias	Alias of the airline. For example, All Nippon Airways is commonly known as "ANA".
 IATA	2-letter IATA code, if available.
 ICAO	3-letter ICAO code, if available.
 Callsign	Airline callsign.
 Country	Country or territory where airline is incorporated.
 Active	"Y" if the airline is or has until recently been operational, "N" if it is defunct.
 This field is not reliable: in particular, major airlines that stopped flying long ago,
 but have not had their IATA code reassigned (eg. Ansett/AN), will incorrectly show as "Y".
 *
 */

//ID,Name,Alias,IataCode,IcaoCode,Callsign,Country,Active
//1355,"British Airways",\N,"BA","BAW","SPEEDBIRD","United Kingdom","Y"
public class Airline {


    Airline(String[] row) {
        this.name = row[1];
        this.iataCode = row[3];
        this.icaoCode = row[4];
        this.country = row[6];
        this.active = row[7].equals("Y")?true:false;
    }

    private final String name;
    private final String iataCode;
    private final String icaoCode;
    private final String country;
    private final boolean active;

    public String getName() {
        return name;
    }

    public Optional<String> getIataCode() {
        if ( iataCode == null || iataCode.trim().length() < 1){
            return Optional.empty();
        }
        return Optional.of(iataCode);
    }

    public Optional<String> getIcaoCode() {
        if ( icaoCode == null || icaoCode.trim().length() < 1){
            return Optional.empty();
        }
        return Optional.of(icaoCode);
    }

    public String getCountry() {
        return country;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", country='" + country + '\'' +
                ", active=" + active +
                '}';
    }
}
