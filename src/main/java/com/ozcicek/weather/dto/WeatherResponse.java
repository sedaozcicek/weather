package com.ozcicek.weather.dto;

public record WeatherResponse(
        Request request,
        Location location,
        Current current

) {

}
