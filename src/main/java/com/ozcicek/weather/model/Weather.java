package com.ozcicek.weather.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Data
public class Weather {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String requestedCityName;
    private String cityName;
    private String country;
    private String temperature;
    private LocalDateTime updatedTime;
    private LocalDateTime responseLocalTime;

}
