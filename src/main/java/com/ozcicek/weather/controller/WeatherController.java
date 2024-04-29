package com.ozcicek.weather.controller;

import com.ozcicek.weather.dto.WeatherDto;
import com.ozcicek.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable("city") String city){
        return ResponseEntity.ok(weatherService.getWeatherByCityName(city));
    }
}