package javase04.t02;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Задание 2. Работа с символьными потоками ввода-вывода
 *  Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
 *  Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.
 *
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> keyWords = new ArrayList<>(Arrays.asList("abstract", "continue", "for", "new", "switch", "assert", "default",
                "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements",
                "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return",
                "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class",
                "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"));

        Map<String, Integer> kWordStat = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new Solution().getFile("javase04/t01/Quiz.java")))) {
            StringBuilder sb = new StringBuilder();
            while(br.ready()){
                sb.append(br.readLine());
            }

            String[] fileArr = sb.toString().split("[\\W]");

            for (String keyword : keyWords) {
                Pattern pattern = Pattern.compile(keyword);

                for (String s : fileArr) {
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.matches()) {
                        if (!kWordStat.containsKey(keyword)) {
                            kWordStat.put(keyword, 1);
                        } else {
                            kWordStat.put(keyword, kWordStat.get(keyword) + 1);
                        }
                    }
                }
            }
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter("keyWordsCh.txt"))) {
            for (Map.Entry<String, Integer> entry : kWordStat.entrySet()) {
                br.write(entry.getKey() + " = " + entry.getValue() + "\n");
            }
        }
    }

    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
