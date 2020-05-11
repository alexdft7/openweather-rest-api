package com.example.openweatherrestapi;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.ResourceBundle;

@Service
public class WeatherService {

    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}";

    private RestTemplate restTemplate;

    private ResourceBundle propertiesBundle = ResourceBundle.getBundle("application");

    public WeatherService() {
        restTemplate = new RestTemplate();
    }

    public WeatherItem getWeather(String city) {
        String key = propertiesBundle.getString("openweatherapi.key");
        URI url = new UriTemplate(WEATHER_URL).expand(city, key);

        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<WeatherItem> response = this.restTemplate
                .exchange(url, HttpMethod.GET, request, WeatherItem.class);

        return response.getBody();
    }
}