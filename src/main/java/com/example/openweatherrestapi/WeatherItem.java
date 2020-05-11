package com.example.openweatherrestapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherItem {

    private DecimalFormat df = new DecimalFormat("#.##");

    private String name;

    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private Integer pressure;
    private Integer humidity;

    private double speed;

    private Integer weatherId;
    private String icon;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = Double.parseDouble(df.format(temperature-273.15));
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = Double.parseDouble(df.format(minTemperature-273.15));
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = Double.parseDouble(df.format(maxTemperature-273.15));
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setMain(Map<String, Object> main) {
        setTemperature(Double.parseDouble(main.get("temp").toString()));
        setMinTemperature(Double.parseDouble(main.get("temp_min").toString()));
        setMaxTemperature(Double.parseDouble(main.get("temp_max").toString()));
        setHumidity((Integer)main.get("humidity"));
        setPressure((Integer)main.get("pressure"));
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setWind(Map<String, Object> wind) {
        setSpeed(Double.parseDouble(wind.get("speed").toString()));
    }

    public Integer getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String weatherIcon) {
        this.icon = weatherIcon;
    }

    public void setWeather(List<Map<String, Object>> weatherItems) {
        Map<String, Object> weather = weatherItems.get(0);
        setWeatherId((Integer) weather.get("id"));
        setIcon((String) weather.get("icon"));
    }
}