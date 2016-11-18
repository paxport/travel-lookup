Travel Lookups
===================

Simple in memory look up service for common travel data

Supports:

* IATA airport code to airport
* IATA carrier code to carrier name

Data files taken from https://github.com/jpatokal/openflights

## Look up airport name

    String name = IataAirportCodes.airportName("BRS").get();
    assertEquals("Bristol", name);
    
  
## JCenter Dependency

    <dependency>
      <groupId>com.paxport</groupId>
      <artifactId>travel-lookup</artifactId>
      <version>1.0.0</version>
    </dependency>

## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"