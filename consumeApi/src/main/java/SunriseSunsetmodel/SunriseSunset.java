package SunriseSunsetmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SunriseSunset(
        String date,
        String sunrise,
        String sunset,
        String golden_hour,
        String day_length
        ) {
}
