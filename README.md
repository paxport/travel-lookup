Travel Lookups
===================

Simple in memory look up service for common travel data

work in progress... currently just supports IATA airport code to airport name

## Look up airport name

    String name = IataAirportCodes.airportName("BRS");
    assertEquals("Bristol International Airport", name);
    
  
## JCenter Dependency

    <dependency>
      <groupId>com.paxport</groupId>
      <artifactId>travel-lookup</artifactId>
      <version>0.1.0</version>
    </dependency>

## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"