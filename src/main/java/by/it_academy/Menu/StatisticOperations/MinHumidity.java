package by.it_academy.Menu.StatisticOperations;

import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by masha on 08.05.2018.
 */
public class MinHumidity {
    List<Weather> weathers=new ArrayList<>();
    HashMap<String, Double> averageHum=new HashMap<>();
    public int findMin(double value){
        averageHum.putAll(new AverageParam().getAverageHum());
        for (String key : averageHum.keySet()) {
            Double value1 = averageHum.get(key);

        }

        weathers.addAll(WeatherBase.getInstance().getWeatherBase());
        for (Weather weather: weathers){

        }
        return 0;
    }
}
