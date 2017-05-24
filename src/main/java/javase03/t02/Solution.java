package javase03.t02;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by rusamaha on 5/17/17.
 */
public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {

        Locale[] supportedLocales = {
                Locale.ENGLISH,
                new Locale("ru", "RU")
        };

        System.out.println("Select language: \n1. English;\n2. Russian");

        Scanner sc = new Scanner(System.in);
        int lang = sc.nextInt();
        if (lang>2 || lang <1) {
            System.out.println("You can choose only 1 or 2");
            return;
        }
        ResourceBundle rb = ResourceBundle.getBundle("javase03.t02.Solution", supportedLocales[--lang]);

        System.out.println(rb.getString("greeting"));

        System.out.println(new String(rb.getString("question1").getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println(rb.getString("question2"));
        System.out.println(rb.getString("question3"));


        while (true) {
            switch (sc.nextInt()) {
                case 0:
                    System.out.println(rb.getString("exit"));
                    return;
                case 1:
                    System.out.println(rb.getString("answer1"));
                    break;
                case 2:
                    System.out.println(rb.getString("answer2"));
                    break;
                case 3:
                    System.out.println(rb.getString("answer3"));
                    break;
                default:
                    System.out.println(rb.getString("defaultAnswer"));
            }
        }
    }
}
