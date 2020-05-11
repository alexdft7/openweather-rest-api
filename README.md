# openweather-rest-api
Приложение Rest API (Java, Spring Boot) для доступа к OpenWeatherMap. Позволяет получить JSON с данными о сегодняшней погоде в любом городе.

Для использования нужно внести OpenWeatherMap API key в application.properties.

В определённых случаях может появляться исключение "java.net.ConnectException", являющееся результатом съеденных пакетов. Скорее всего, вызвано фаерволом на стороне провайдера или самого OpenWeatherMap. Решается подключением VPN.
