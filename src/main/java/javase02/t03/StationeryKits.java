package javase02.t03;

import javase02.t02.stationery.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rusamaha on 5/14/17.
 */
public class StationeryKits {

    public enum KitType {BASIC, STANDARD, PROFESSIONAL}

    public static List<Stationery>  stationeryKit(KitType kitType) {

        ArrayList<Stationery> list = null;

        switch (kitType) {
            case BASIC:
                list = new ArrayList<>(Arrays.asList(
                        new Ruler("Small ruler", 200),
                        new Pen("Simple pen", 300),
                        new Notepad("Small notepad", 150),
                        new Sharpener("Sharpener", 200)
                ));
                break;
            case STANDARD:
                list = new ArrayList<>(Arrays.asList(
                        new Ruler("Big ruler", 300),
                        new Pen("Mechanical pen", 500),
                        new Notepad("Big notepad", 250),
                        new Sharpener("Sharpener", 200)
                ));
                break;
            case PROFESSIONAL:
                list = new ArrayList<>(Arrays.asList(
                        new Ruler("Small ruler", 200),
                        new Ruler("Big ruler", 300),
                        new Ruler("Engineer ruler", 300),
                        new Pen("Simple pen", 300),
                        new Pen("Professional pen", 300),
                        new Pen("Mechanical pen", 500),
                        new Notepad("Big notepad", 250),
                        new Notepad("Small notepad", 150),
                        new Notepad("Sketch notepad", 150)


                ));
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Stationery> basicKit = StationeryKits.stationeryKit(KitType.BASIC);
        System.out.println("Basic kit:");
        basicKit.forEach(System.out::println);
    }
}
