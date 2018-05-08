package by.it_academy;

import by.it_academy.Menu.Menu;
import by.it_academy.Menu.StatisticOperations.LocationList;
import by.it_academy.Weather.WeatherBase;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherBase.getInstance().create();
        LocationList.getInstance().createLocationList();
        new Menu().start();
    }
}