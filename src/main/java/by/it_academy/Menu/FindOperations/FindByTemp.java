package by.it_academy.Menu.FindOperations;

import by.it_academy.Weather.Weather;

import java.util.List;

public class FindByTemp {
    public void findByTemp(List<Weather> weathers, int max_t, int min_t) {
        boolean flag=false;
        for (Weather weather : weathers) {
            if (weather.getMax_temp() <= max_t && weather.getMin_temp() >= min_t) {
                    flag = true;
                    System.out.println(weather);
            }
        }
        if (!flag) {
            System.out.println("Не найдено!!!");
        }
    }
}
