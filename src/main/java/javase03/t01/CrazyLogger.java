package javase03.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rusamaha on 5/17/17.
 */
public class CrazyLogger {
    StringBuilder sb = new StringBuilder();
    private static final DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy : hh:mm:ss - ");

    void addMessage(String message){
        Date date = new Date();
        sb.append(sdf.format(date)).append(message).append('\n');

    }


}
