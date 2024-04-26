package com.ozcicek.weather.dto;

public record Request(
        String type,
        String query,
        String lannduage,
        String unit
) {
}
