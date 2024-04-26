package com.ozcicek.weather.repository;

import com.ozcicek.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, String> {

}
