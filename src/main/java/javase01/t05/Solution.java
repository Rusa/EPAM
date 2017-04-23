package javase01.t05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rusamaha on 4/23/17.
 */

//Получить матрицу:
//    1 0 0 0 0 0 1
//    0 1 0 0 0 1 0
//    0 0 1 0 1 0 0
//    0 0 0 1 0 0 0
//    0 0 1 0 1 0 0
//    0 1 0 0 0 1 0
//    1 0 0 0 0 0 1

public class Solution {
    public static void main(String[] args) {
        System.out.println("Enter quantity of elements for matrix :");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            a[i][i] = 1;
            a[i][n-1-i] = 1;
        }

        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
