package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by rusamaha on 5/23/17.
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = readFile("attachment.html");
        List<String> listOfSPic = allSentencesWithPic(file.toString());

        System.out.println("Предложения в которых встречаются ссылки на рисунки: ");
        int i = 0;
        for (String s : listOfSPic) {
            System.out.println(++i + ") " + s);
        }

        System.out.println("Посследовательность ссылок на рисунки: ");
        boolean isCons = isPicConsistently(file.toString());

        if (isCons) {
            System.out.println("\nНомера упорядоченны");
        } else {
            System.out.println("\nНомера не упорядоченны");
        }
    }

    private static StringBuilder readFile(String file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(getResource(file))) {
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    /**
     * @param str String to search
     * @return <code>true</code> if nums of pictures ordered
     */
    private static boolean isPicConsistently(String str) {

        Pattern patternImg = Pattern.compile("[<img]?>((((Рис\\.)\\s*)(\\d+)).*?)");   // only text with number under pictures for solving over conditions
        Pattern patternImgN = Pattern.compile("(р|Р)ис\\.?\\s*\\D{0,5}\\s*(\\d+)");  // number after picture word

        Matcher matcher;

        ArrayList<Integer> orderList = new ArrayList<>();
        for (String s : allSentencesWithPic(str)) {
            matcher = patternImgN.matcher(s);
            while (matcher.find()) {
                int numOfPic = Integer.parseInt(matcher.group(2));
                orderList.add(numOfPic);
                System.out.print(numOfPic + " ");
            }
        }
        int current = 0;

        for (Integer i : orderList) {
            if(i<current) return false;
            current = i;
        }
        return true;
    }


    /**
     *
     * @param file
     * @return All sentences with "рис NUM"(and variations) without Sentences under images
     */
    private static List<String> allSentencesWithPic(String file) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("([А-Я][^.?!]+?)(((((р|Р)ис\\.?)\\s*\\D{0,5}\\s*)(\\d+)).*?)+?[.!?]\\s*?");
        Matcher matcher = pattern.matcher(file);
        int i = 0;
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        return list;
    }

    private static InputStreamReader getResource(String name) throws UnsupportedEncodingException {
        Class<Solution> cls = Solution.class;
        return new InputStreamReader(cls.getResourceAsStream(name), "windows-1251");
    }
}

