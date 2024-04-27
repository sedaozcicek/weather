package com.ozcicek.weather.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozcicek.weather.dto.WeatherDto;
import com.ozcicek.weather.dto.WeatherResponse;
import com.ozcicek.weather.model.Weather;
import com.ozcicek.weather.repository.WeatherRepository;
import com.ozcicek.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class WeatherServiceImpl implements WeatherService {


    private static final String API_URL = "http://api.weatherstack.com/current?access_key=69ffb46b0c27349b2175101ffe96e33f&query=";
    private final WeatherRepository weatherRepository;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherServiceImpl(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherDto getWeatherByCityName(String city) {
        Optional<Weather> optionalWeather = weatherRepository.findFirstByRequestedCityNameOrderByUpdatedTimeDesc(city);
        if (!optionalWeather.isPresent()) {
            return WeatherDto.convert(getWeatherFromWeatherStack(city));
        }

        return WeatherDto.convert(optionalWeather.get());

    }

    private Weather getWeatherFromWeatherStack(String city) {
        // responseEntity bize json şeklinde dönecek bu sayede
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_URL + city, String.class);
        try {
            WeatherResponse weatherResponse = objectMapper.readValue(responseEntity.getBody(), WeatherResponse.class);
            return saveWeather(city,weatherResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Weather saveWeather(String city, WeatherResponse weatherResponse) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Weather weather = new Weather(city,
                weatherResponse.location().name(),
                weatherResponse.location().country(),
                weatherResponse.current().temperature(),
                LocalDateTime.now(),
                LocalDateTime.parse(weatherResponse.location().localtime(), dateTimeFormatter)
        );

        return weatherRepository.save(weather);
    }

}
