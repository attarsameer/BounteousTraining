package com.example.WeatherForecastingSystem.Weather.controller;

import com.example.WeatherForecastingSystem.Weather.model.WeatherForecast;
import com.example.WeatherForecastingSystem.Weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final Map<String, double[]> cityCoordinates;

    public WeatherController(WeatherService ws) throws Exception {
        this.weatherService = ws;
        this.cityCoordinates = ws.loadCoordinatesFromExcel("Coordinates.xlsx");
    }

    @GetMapping("/{city}")
    public Map<LocalDate, WeatherForecast> getForecastForCity(@PathVariable String city) {
        return weatherService.getForecast(city, cityCoordinates);
    }

    @GetMapping("/compare")
    public List<String> compareCityForecasts(
            @RequestParam String city1, @RequestParam String city2) {
        return weatherService.compareCities(city1, city2, cityCoordinates);
    }
}