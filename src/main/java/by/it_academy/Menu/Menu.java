package by.it_academy.Menu;

import java.util.Scanner;

public class Menu implements MenuSkin {

    private Operations operations = new Operations();

    public void start(){
        while (true)
            operations.getOperationMap(skin());
    }

    @Override
    public int skin() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.Показать погоду.");
        System.out.println("2.Поиск.");
        System.out.println("3.Статистика.");
        System.out.println("0.Выход.");
        choice = scanner.nextInt();
        return choice;
    }
}
