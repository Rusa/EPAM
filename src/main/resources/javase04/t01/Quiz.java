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
        if (lang > 2 || lang < 1) {
            System.out.println("You can choose only 1 or 2");
            return;
        }
        ResourceBundle rb = ResourceBundle.getBundle("javase03.t02.Solution", supportedLocales[--lang]);

        System.out.println(rbToUTFString(rb, "greeting"));

        System.out.println(rbToUTFString(rb, "question1"));
        System.out.println(rbToUTFString(rb, "question2"));
        System.out.println(rbToUTFString(rb, "question3"));

        while (true) {
            switch (sc.nextInt()) {
                case 0:
                    System.out.println(rbToUTFString(rb, "exit"));
                    return;
                case 1:
                    System.out.println(rbToUTFString(rb, "answer1"));
                    break;
                case 2:
                    System.out.println(rbToUTFString(rb, "answer2"));
                    break;
                case 3:
                    System.out.println(rbToUTFString(rb, "answer3"));
                    break;
                default:
                    System.out.println(rbToUTFString(rb, "defaultAnswer"));
            }
        }
    }

    private static String rbToUTFString(ResourceBundle rb, String str) throws UnsupportedEncodingException {
        return new String(rb.getString(str).getBytes("ISO-8859-1"), "UTF-8");
    }
}
