package by.it_academy.Weather;

import by.it_academy.Parsing.ParseJSON;
import by.it_academy.Parsing.ParseXML;

import java.util.ArrayList;
import java.util.List;

public class WeatherBase {
    private List<Weather> weatherBase = new ArrayList<>();
    private static WeatherBase instance = null;

    private WeatherBase() {
    }

    public static WeatherBase getInstance() {
        if (instance == null) instance = new WeatherBase();
        return instance;
    }

    public List<Weather> create() throws Exception {
        weatherBase.addAll(new ParseXML().read());
        weatherBase.addAll(new ParseJSON().read());
        return weatherBase;
    }

    public List<Weather> getWeatherBase() {
        return weatherBase;
    }
}
