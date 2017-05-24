package javase03.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rusamaha on 5/17/17.
 */
public class CrazyLogger {
    private StringBuilder sb = new StringBuilder();
    private static final DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy : hh:mm:ss - ");

    void addMessage(String message){
        Date date = new Date();
        sb.append(sdf.format(date)).append(message).append(">|||-_-|||<").append('\n');
    }

    void showLog(){
        System.out.println(sb);
    }

    void search(String s) {
        Pattern pattern = Pattern.compile("[0-9].*"+s+".*(>|||-_-|||<)");
        Matcher matcher = pattern.matcher(sb.toString());
        int i = 1;
        while (matcher.find()) {
            System.out.println("Found entry number " + i++);
            System.out.println(matcher.group());
        }

    }
    //LocaleDateTime Java8
}
