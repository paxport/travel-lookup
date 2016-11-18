package com.paxport.lookup.airport;

/**
 *
 *
 Airport ID	Unique OpenFlights identifier for this airport.
 Name	Name of airport. May or may not contain the City name.
 City	Main city served by airport. May be spelled differently from Name.
 Country	Country or territory where airport is located.
 IATA/FAA	3-letter FAA code, for airports located in Country "United States of America".
 3-letter IATA code, for all other airports.
 Blank if not assigned.
 ICAO	4-letter ICAO code.
 Blank if not assigned.
 Latitude	Decimal degrees, usually to six significant digits. Negative is South, positive is North.
 Longitude	Decimal degrees, usually to six significant digits. Negative is West, positive is East.
 Altitude	In feet.
 Timezone	Hours offset from UTC. Fractional hours are expressed as decimals, eg. India is 5.5.
 DST	Daylight savings time. One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown). See also: Help: Time
 Tz database time zone	Timezone in "tz" (Olson) format, eg. "America/Los_Angeles".
 *
 */

//ID,Name,City,Country,IataCode,IcaoCode,Latitude,Longitude,Altitude,OffsetHours,DST,Timezone
//507,"Heathrow","London","United Kingdom","LHR","EGLL",51.4775,-0.461389,83,0,"E","Europe/London"
public class Airport {

    Airport(String[] row) {
        this.name = row[1];
        this.city = row[2];
        this.country = row[3];
        this.iataCode = row[4];
        this.latitude = Double.parseDouble(row[6]);
        this.longitude = Double.parseDouble(row[7]);
        this.timezone = row[11];
    }

    private final String name;
    private final String city;
    private final String country;
    private final String iataCode;
    private final double latitude;
    private final double longitude;
    private final String timezone;

    public String getName() {
        return name;
    }

    public String getCityPlusName() {
        if ( name.equals(city) ){
            return name;
        }
        else {
            return city + " " + name;
        }
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public boolean hasIataCode(){
        return iataCode != null && iataCode.trim().length() > 0;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
