package javase01.t02;

import java.util.Scanner;

/**
 * Created by rusamaha on 4/23/17.
 */

// Найти наименьший номер элемента последовательности, для которого выполняется условие M.
// Вывести на экран этот номер и все элементы ai  где i = 1, 2, ..., п.
// a[i] = 1, 2, 3, 4, 5 ... n.
// a[n] = 1/(n+1)^2, M: a[n]< eps

// 1/(n+1)^2 < eps
// 1/eps < (n+1)^2
// 1/eps^(1/2) - 1 < n

// n = Math.ceiling( 1/eps^(1/2) - 1)

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Epsilon");
        double eps = scanner.nextDouble();
        if (eps<0) {
            throw new IllegalArgumentException("eps should be greater than 0");
        }

        int n = (int) Math.floor(1.0 / Math.sqrt(eps) - 1) + 1;
        System.out.println(n);

        for (int i = 1; i <= n; i++) {
            double a = 1 / Math.pow((i + 1), 2);
            System.out.printf("%e \n",a);
        }
    }
}

