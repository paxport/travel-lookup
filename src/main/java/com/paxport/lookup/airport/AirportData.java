package com.paxport.lookup.airport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;


/**
 *
 *     {
 *       "iata": "BRS",
 *       "lon": "-2.710659",
 *       "iso": "GB",
 *       "status": 1,
 *       "name": "Bristol International Airport",
 *       "continent": "EU",
 *       "type": "airport",
 *       "lat": "51.386757",
 *       "size": "large"
 *      },
 *
 */

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableAirportData.class)
@JsonDeserialize(as = ImmutableAirportData.class)
public abstract class AirportData {

    public enum Type { airport, heliport, seaplanes, closed }

    public enum Size { small, medium, large }

    @Nullable
    public abstract String getIata();

    @Nullable
    public abstract String getLon();

    @Nullable
    public abstract String getIso();

    @Nullable
    public abstract Integer getStatus();

    @Nullable
    public abstract String getName();

    @Nullable
    public abstract String getContinent();

    @Nullable
    public abstract Type getType();

    @Nullable
    public abstract String getLat();

    @Nullable
    public abstract Size getSize();

}
