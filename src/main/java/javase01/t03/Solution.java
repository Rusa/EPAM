package javase01.t03;

import java.util.Scanner;

/**
 * Created by rusamaha on 4/23/17.
 */

// Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
// Результат представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции:
//    F(x) = tg(2x)-3


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter begin point for segment:");
        double a = scanner.nextDouble();
        System.out.println("Enter end point for segment:");
        double b = scanner.nextDouble();
        System.out.println("Enter step for function:");
        double h = scanner.nextDouble();
        scanner.close();

        System.out.println("----------------------------");
        System.out.println("|      x     |   tgFunc(x) |");
        System.out.println("----------------------------");
        for (double i = a; i<=b; i+=h ){
            System.out.format("|%-10.2f  |  %10.2f |\n", i, tgFunc(i));
        }
        System.out.println("----------------------------");
    }

    private static double tgFunc(double x){
        return Math.tan(2*x) - 3;            //
    }
}
