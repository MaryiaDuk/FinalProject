package by.it_academy.Menu.FindOperations;

import by.it_academy.Menu.StatisticOperations.LocationList;
import by.it_academy.Weather.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindHumidity {
    HashMap<String,List> hashMap = new HashMap<>();

    public void findHum(List<Weather> weathers, double aveHum) {
        List<String> list = new ArrayList<>();
        List<Weather> tmp = new ArrayList<>();
        list.addAll(LocationList.getInstance().getLocationList());
        System.out.println("lockList"+list.size());
        for (int i=0; i<list.size(); i++){
            for (int j=0; j< weathers.size(); j++) {
                if (list.get(i).equals(weathers.get(j).getLocation()))
                    if (weathers.get(j).getHumidity() >= aveHum) {
                        tmp.add(weathers.get(j));
                    }
            }

            System.out.println(list.get(i));
            System.out.println(tmp);
            hashMap.put(list.get(i), tmp);
        }
      //  System.out.println(hashMap);
    }
}

