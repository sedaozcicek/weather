package com.ozcicek.weather.repository;

import com.ozcicek.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, String> {

    //SELECT * FROM weather WHERE requestedCityName ORDER BY updateTime DESC LIMIT 1
    Optional<Weather> findFirstByRequestedCityNameOrderByUpdatedTimeDesc(String city);

    List<Weather> findAllByRequestedCityNameOrderByUpdatedTimeDesc(String city);
}
