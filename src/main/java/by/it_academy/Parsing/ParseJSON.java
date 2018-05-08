package by.it_academy.Parsing;

import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.*;

public class ParseJSON implements ParseFiles {
    List<Weather> weatherList = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(Weather.class, new WeatherJSONDeserializer()).create();

    @Override
    public List<Weather> read() throws Exception {
        try  {
            URL url = new URL("https://raw.githubusercontent.com/MaryiaDuk/weather/master/weather1.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            WeatherList weather = gson.fromJson(new BufferedReader
                    (new InputStreamReader(connection.getInputStream())), WeatherList.class);
              weatherList = weather.getPlace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherList;
    }
}