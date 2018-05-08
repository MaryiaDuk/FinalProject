package by.it_academy.Menu.StatisticOperations;

import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherBase;

import java.util.*;

public class AverageParam {
    List<Weather> list = new ArrayList<>();
    HashMap<String, Double> hashMapTemp = new HashMap<>();
    HashMap<String, Double> hashMapHum = new HashMap<>();

    List<String> locationList = new ArrayList<>();

    public HashMap<String, Double> getAverageTemp() {
        list.addAll(WeatherBase.getInstance().getWeatherBase());
        int tmp = 0;
        locationList.addAll(LocationList.getInstance().getLocationList());
        for (String aLocationList : locationList) {
            double averageTemp = 0;
            double averageHum = 0;
            for (Weather weather : list) {
                if (aLocationList.equals(weather.getLocation())) {
                    averageTemp += weather.getMax_temp();
                    averageHum+= weather.getHumidity();
                    tmp++;
                }
            }

            hashMapTemp.put(aLocationList, averageTemp / tmp);
            tmp = 0;
        }
        return hashMapTemp;
    }

    public HashMap<String, Double> getAverageHum() {
        list.addAll(WeatherBase.getInstance().getWeatherBase());
        int tmp = 0;
        locationList.addAll(LocationList.getInstance().getLocationList());
        for (String aLocationList : locationList) {
            double averageHum = 0;
            for (Weather weather : list) {
                if (aLocationList.equals(weather.getLocation())) {
                    averageHum+= weather.getHumidity();
                    tmp++;
                }
            }
            hashMapHum.put(aLocationList, averageHum / tmp);
            tmp = 0;
        }
        return hashMapHum ;
    }

    public void showTemp() {
        HashMap<String, Double> showHashMap = new HashMap<>();
        showHashMap.putAll(getAverageTemp());
        for (String key : showHashMap.keySet()) {
            String value = showHashMap.get(key).toString();
            System.out.println(key + " " + value);
        }
    }
}