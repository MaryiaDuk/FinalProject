package by.it_academy.Menu.FindOperations;

import by.it_academy.Menu.MenuSkin;
import by.it_academy.Menu.Operation;
import by.it_academy.Weather.Weather;
import by.it_academy.Weather.WeatherBase;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindOperation implements Operation, MenuSkin {
    private Scanner scanner = new Scanner(System.in);
    private List<Weather> list = new ArrayList<>();

    private void find(int choice) {
        list.addAll(WeatherBase.getInstance().getWeatherBase());
        if (choice == 1) {
            System.out.println("Введите город:");
            new FindByCity().findCities(list, scanner.nextLine());
        } else if (choice == 2) {
            System.out.println("Введите максимальную и минимальную температуры: ");
            try {
                int max = scanner.nextInt();
                int min = scanner.nextInt();
                new FindByTemp().findByTemp(list, max, min);
            } catch (InputMismatchException i) {
                System.out.println("Введены неверные данные!!!");
            }
        }
    }

    @Override
    public void execute() {
        find(skin());
    }

    @Override
    public int skin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поиск :");
        System.out.println("1 - По городу.");
        System.out.println("2 - По диапозону максимальной и минимальной температур.");
        return scanner.nextInt();
    }
}
