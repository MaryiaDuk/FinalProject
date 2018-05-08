package by.it_academy.Menu.FindOperations;

import by.it_academy.Weather.Weather;

import java.util.List;

public class FindByCity {

    public void findCities(List<Weather> weathers, String name) {
        boolean flag = false;
        for (Weather weather : weathers) {
            if (weather.getName().equals(name)) {
                System.out.println(weather);
                flag = true;
            }
        }
        if (flag==false) {
            System.out.println("Не найдено!!!");
        }
    }
}
