package by.it_academy.Menu;


import by.it_academy.Sorts.DefaultSorting;
import by.it_academy.Sorts.SortByDescription;

import java.util.Scanner;

public class ShowOperation implements Operation, MenuSkin {
private Scanner scanner = new Scanner(System.in);

    private void show(int choice){
        if (choice == 1){
            new DefaultSorting().defSort();
        }
        if(choice==2){
            new SortByDescription().descSort();
        }
    }
    @Override
    public void execute() {
        show(skin());
    }

    @Override
    public int skin() {
        System.out.println("Сортировка по:");
        System.out.println("1 - Городам");
        System.out.println("2 - Погоде");
        return scanner.nextInt();
    }
}
