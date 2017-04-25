package javase01.t04;

import java.util.*;

/**
 * Created by rusamaha on 4/23/17.
 */

// Код для условия:
// Даны действительные числа a1, a2 … a[2n].  Найти
// max(a[1]+a[2n],a[2]+a[2n-1],a[1]+a[2n],....a[n]+a[n+1])
//


// From sides to center version -
// actual version with changed conditions is SolutionWithChangedTerms.java in current directory.
public class Solution {
    public static void main(String[] args) {

        System.out.println("Enter amount of elements:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //Mock array:
        int arraySize = 2*n;
        double[] arr = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = (int)(Math.random()*5);
        }

        System.out.println("Current array:" + Arrays.toString(arr));
        System.out.println("Max is " + max(arr));
    }
    private static double max(double[] arr){
        int length = arr.length;

        double max = arr[0] + arr[length-1];

        double temp;
        for (int i = 1; i < length-2; i++) {
            temp = arr[i] + arr[length-1-i];
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }
}
