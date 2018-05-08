package by.it_academy.Menu.StatisticOperations;

import by.it_academy.Sorts.SortHumMax;
import by.it_academy.Sorts.SortHumMin;
import by.it_academy.Weather.Weather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AverageHumidity {
    private List<Weather> listMin = new ArrayList<>();
    private List<Weather> listMax = new ArrayList<>();
    private HashMap<String, Double> averageTemp = new HashMap<>();


    public void showAverageHumidity(List<Weather> weathers) {
        averageTemp.putAll(new AverageParam().getAverageHum());
        for (String key : averageTemp.keySet()) {
            Double value = averageTemp.get(key);
            for (Weather weather : weathers) {
                if (key.equals(weather.getLocation()) && weather.getHumidity() > value) {
                    listMax.add(weather);
                }
                if (key.equals(weather.getLocation()) && weather.getHumidity() < value) {
                    listMin.add(weather);
                }
            }
            System.out.println("Средняя влажность:" + key + " " + value);
            Collections.sort(listMin, new SortHumMax());
            Collections.sort(listMax, new SortHumMin());
            System.out.println(listMax.get(0).toString());
            System.out.println(listMin.get(0).toString());
            listMax.clear();
        }
    }
}
