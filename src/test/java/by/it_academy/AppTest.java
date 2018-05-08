package by.it_academy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import by.it_academy.Menu.FindOperations.FindByCity;
import by.it_academy.Sorts.SortByDescription;
import by.it_academy.Weather.Weather;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class AppTest {

    @Test
    public void SortByDescriptionTest() {
        List<Weather> list = new ArrayList<>();
        TreeSet<Weather> sortedList = new TreeSet<>(new SortByDescription());
        list.add(Weather.WeatherBuilder.createWeatherBuilder().setLocation("Europe")
                .setName("Вена").setMax_T("25").setMin_T("10").setHumidity("50").setDescription("rainy").getWeather());
        list.add(Weather.WeatherBuilder.createWeatherBuilder().setLocation("Europe")
                .setName("Прага").setMax_T("20").setMin_T("8").setHumidity("30").setDescription("sunny").getWeather());
        sortedList.addAll(list);
        assertEquals(list, new ArrayList<Weather>(sortedList));
    }

    @Test
    public void FindByCity(){
        List<Weather> list = new ArrayList<>();
        list.add(Weather.WeatherBuilder.createWeatherBuilder().setLocation("Europe")
                .setName("Вена").setMax_T("25").setMin_T("10").setHumidity("50").setDescription("rainy").getWeather());
        list.add(Weather.WeatherBuilder.createWeatherBuilder().setLocation("Europe")
                .setName("Прага").setMax_T("20").setMin_T("8").setHumidity("30").setDescription("sunny").getWeather());
        String name = "Вена";
        new FindByCity().findCities(list, name);
    }
}
