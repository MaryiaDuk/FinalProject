package by.it_academy.Menu.StatisticOperations;

import by.it_academy.Menu.MenuSkin;
import by.it_academy.Menu.Operation;
import by.it_academy.Weather.WeatherBase;

import java.util.Scanner;

public class StatisticOperation implements Operation, MenuSkin {
    private Scanner scanner = new Scanner(System.in);

    public void showStatistic(int choice) {
        if(choice==1){
            new AverageParam().showTemp();
        }
        if(choice==2){
            new PercentCities().showPercent(WeatherBase.getInstance().getWeatherBase());
        }
        if(choice==3){
            new AverageHumidity().showAverageHumidity(WeatherBase.getInstance().getWeatherBase());
        }
    }

    @Override
    public int skin() {
        System.out.println("Показать статистику по регионам");
        System.out.println("1 - Средняя температура");
        System.out.println("2 - % городов с темперотурой выше средней");
        System.out.println("3 - Города с влажность наиболее близкой к средней");
        return scanner.nextInt();
    }

    @Override
    public void execute() {
        showStatistic(skin());
    }
}