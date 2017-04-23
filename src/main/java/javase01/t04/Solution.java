package javase01.t04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rusamaha on 4/23/17.
 */

//
//Даны действительные числа a1, a2 … a[2n].  Найти
// max(a[1]+a[2n],a[2]+a[2n-1],a[1]+a[2n],....a[n]+a[n+1])
//

public class Solution {
    public static void main(String[] args) {

        System.out.println("Enter amount of elements:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arrLength = 2*n;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrLength; i++) {
            list.add(i+1);
        }

        int max = 0;
        int temp = 0;
        for (int i = 1; i < arrLength; i++) {
            temp = list.get(i) + list.get(arrLength-1-i);
            if(max < temp){
                max = temp;
            }
        }

        System.out.println("Max is " + temp);
    }
}
