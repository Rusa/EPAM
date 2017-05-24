package javase02.t03;

import javase02.t02.stationery.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rusamaha on 5/14/17.
 */

//Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.


public class StationeryKits {

    public enum KitType {BASIC, STANDARD, PROFESSIONAL}

    public static List<Stationery> stationeryKit(KitType kitType) {

        switch (kitType) {
            case BASIC:
                return Arrays.asList(
                        new Ruler("Small ruler", 200),
                        new Pen("Simple pen", 300),
                        new Notepad("Small notepad", 150),
                        new Sharpener("Sharpener", 200)
                );
            case STANDARD:
                return Arrays.asList(
                        new Ruler("Big ruler", 300),
                        new Pen("Mechanical pen", 500),
                        new Notepad("Big notepad", 250),
                        new Sharpener("Sharpener", 200)
                );
            case PROFESSIONAL:
                return Arrays.asList(
                        new Ruler("Small ruler", 200),
                        new Ruler("Big ruler", 300),
                        new Ruler("Engineer ruler", 300),
                        new Pen("Simple pen", 300),
                        new Pen("Professional pen", 300),
                        new Pen("Mechanical pen", 500),
                        new Notepad("Big notepad", 250),
                        new Notepad("Small notepad", 150),
                        new Notepad("Sketch notepad", 150)
                );
            default:
                System.out.println("Where is no type " + kitType);
                throw new IllegalArgumentException(
                        "unknown type" + kitType
                );
        }
    }

    public static void main(String[] args) {
        List<Stationery> basicKit = StationeryKits.stationeryKit(KitType.BASIC);
        System.out.println("Basic kit:");
        basicKit.forEach(System.out::println);
    }
}
