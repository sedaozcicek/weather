package com.ozcicek.weather.service.Impl;

import com.ozcicek.weather.dto.WeatherDto;
import com.ozcicek.weather.repository.WeatherRepository;
import com.ozcicek.weather.service.WeatherService;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public WeatherDto getWeatherByCityName(String city) {
        return null;
    }
}
