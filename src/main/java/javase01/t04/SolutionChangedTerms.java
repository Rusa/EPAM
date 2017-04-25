package javase01.t04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rusamaha on 4/24/17.
 */
public class SolutionChangedTerms {
//    Уточненное и измененное условие Радмиром:
//    Если число элементов четное - последним элементом будет сумма, если нечетное, то пусть оно само по себе будет
//    (не суммируется ни с кем). немного усугубим задачу)
//    вот тест для усугубленного задания:
//    для последовательности 1,2,3,4,5,6
//    max(1+2, 3+4, 5+6) -> 11
//    для последовательности 1, 2, 3, 5, 10
//    max (1+2, 3+5, 10) -> 10


    public static void main(String[] args) {

        System.out.println("Enter amount of elements:");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();

        //Mock array:

        double[] arr = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = i;//(int)(Math.random()*5);
        }

        System.out.println("Current array:" + Arrays.toString(arr));
        System.out.println("Max is " + max(arr));
    }
    private static double max(double[] arr){
        int length = arr.length;

        double max = arr[length-1];  // temp max for odd amount
        length -= 1;
        if(length % 2 == 0){
            max = arr[length-1] + arr[length-2]; // temp max for even amount
            length -= 1;
        }

        double temp;
        for (int i = 0; i < length; i+=2) {
            temp = arr[i] + arr[i+1];
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }
}
