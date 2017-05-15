package javase02.t02;

import javase02.t02.stationery.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rusamaha on 5/11/17.
 */
public class Solution {

    public static void main(String[] args) {

        List<WorkPlace> workPlaces = getWorkPlaces();

        calcSum(workPlaces);
    }

    private static void calcSum(List<WorkPlace> workPlaces) {
        for (WorkPlace workPlace: workPlaces){
            System.out.printf("Worker %s owns stuff amount of: ", workPlace.getEmployee().getName());
            Double sum = 0.0;
            for (Stationery item: workPlace.getStationery()){
                sum+=item.getCost();
            }
            System.out.println(sum);
        }
    }

    private static List<WorkPlace> getWorkPlaces() {
        Ruler rulerS = new Ruler("Small ruler", 200);
        Ruler rulerB = new Ruler("Big ruler", 300);

        Pen penS = new Pen("Simple pen", 300);
        Pen penM = new Pen("Mechanical pen", 500);

        Notepad notepadS = new Notepad("Small notepad", 150);
        Notepad notepadB = new Notepad("Big notepad", 250);

        Sharpener sharpener = new Sharpener("Sharpener", 200);

        List<Stationery> simpleStuff = new ArrayList<>(Arrays.asList(penS, notepadS, rulerS, sharpener));
        List<Stationery> basicStuff = new ArrayList<>(Arrays.asList(penS, notepadB, rulerB, sharpener));
        List<Stationery> profStuff = new ArrayList<>(Arrays.asList(penS, penM, notepadS, notepadB, rulerS, rulerB, sharpener));

        List<WorkPlace> workPlaces = new ArrayList<>();

        Employee employee1 = new Employee("Petya");
        workPlaces.add(new WorkPlace(employee1, simpleStuff));

        Employee employee2 = new Employee("Vasya");
        workPlaces.add(new WorkPlace(employee2, basicStuff));

        Employee employee3 = new Employee("Vanya");
        workPlaces.add(new WorkPlace(employee3, profStuff));
        return workPlaces;
    }
}
