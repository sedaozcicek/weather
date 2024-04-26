package com.ozcicek.weather.service;

import com.ozcicek.weather.dto.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    WeatherDto getWeatherByCityName(String city);
}
