package javase05.t02;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        System.out.println("Enter name of properties file: ");
        Scanner sc = new Scanner(System.in);
        String propFile = sc.nextLine();  // se0502.properties
        String key = sc.nextLine();       // exit
        PropertyReader pr = new PropertyReader();

        System.out.println(pr.getValueByKey(propFile, key));


    }
}