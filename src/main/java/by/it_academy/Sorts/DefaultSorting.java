package by.it_academy.Sorts;

import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultSorting {
    List<Weather> weathers = new ArrayList<>();

    public void defSort() {
        weathers.addAll(WeatherBase.getInstance().getWeatherBase());
        show(weathers);
    }

    private void show(List<Weather> list) {
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list);
            System.out.println(list.get(i));
        }
    }
}