package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.apple.eio.FileManager.getResource;

/**
 * Created by rusamaha on 5/23/17.
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = readFile("attachment.html");
        List<String> listOfSentence  = allSentencesWithPic(file);

        System.out.println("Предложения в которых стречаются ссылки на рисунки: ");
        int i =0;
        for(String s: listOfSentence){
            System.out.println(++i +") "+ s);
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

    private boolean isPicConsistently(String s){
        Pattern pattern = Pattern.compile("[<img]?>((((Рис\\.)\\s*)(\\d+)).*?)"); // only text with number under pictures

        return true;
    }


    /**
     *  Whole sentences with "рис NUM"(and variations) without text under images
     *
     * @param file
     * @return
     */
    private static List<String> allSentencesWithPic(StringBuilder file){
        List<String> list = new ArrayList<>();
//        Pattern pattern = Pattern.compile("([А-Я][^.?!]+?)(((((р|Р)ис\\.?)\\s*\\D{0,5}\\s*)(\\d+)).*?)+?[.!?]\\s*?(?![А-Я])");
        Pattern pattern = Pattern.compile("([А-Я][^.?!]+?)(((((р|Р)ис\\.?)\\s*\\D{0,5}\\s*)(\\d+)).*?)+?[.!?]\\s*?");
        Matcher matcher = pattern.matcher(file);
        int i = 0;
        while (matcher.find()){
            list.add(matcher.group(0));

        }

        return list;

//        рис\.?\s*\d{0,3}


//        ((р|Р)ис\.?\s*\D?)(\d+)
//        ((р|Р)ис\.+\s*\D*)(\d+)


//        ((р|Р)ис\.?\s*\D{0,5}\s*)(\d+)\s*
//        ((р|Р)ис\.?\s*\D{0,5}\s*)(\d+)\s*(\d?)
//        ((р|Р)ис\.?\s*\D{0,5}\s*)(\d+)
//        ((р|Р)ис\.?\s*\D{0,5}\s*)(\d+)
//        (?>([А-Я].*?)(рис.*?)(\.))

//        ([А-Я][^\.\?\!]+?)(((((р|Р)ис\.?)\s*\D{0,5}\s*)(\d+)).*?)+?[\.\!\?]\s*?(?![А-Я])


    }

    private static InputStreamReader getResource(String name) throws UnsupportedEncodingException {
        Class<Solution> cls = Solution.class;
        return new InputStreamReader(cls.getResourceAsStream(name), "windows-1251");
    }
}

