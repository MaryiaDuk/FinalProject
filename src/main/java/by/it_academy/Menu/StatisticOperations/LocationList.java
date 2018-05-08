package by.it_academy.Menu.StatisticOperations;


import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherBase;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LocationList {
    private List<String> locationList = new ArrayList<>();
    private static LocationList instance = null;

    private LocationList() {
    }

    public static LocationList getInstance(){
        if (instance==null) instance=new LocationList();
        return instance;
    }
    public List<String> createLocationList() {
        Set<String> locationListSet = new LinkedHashSet<>();
        for (Weather aList : WeatherBase.getInstance().getWeatherBase()) {
            locationListSet.add(aList.getLocation());
            locationList.addAll(locationListSet);
        }
        return locationList;
    }

    public List<String> getLocationList(){
        return locationList;
    }
}