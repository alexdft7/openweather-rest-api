package com.example.openweatherrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenWeatherRestController {

    private WeatherService weatherService;

    public OpenWeatherRestController() {
        weatherService = new WeatherService();
    }

    @GetMapping("/weather/{city}")
    public WeatherItem getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
