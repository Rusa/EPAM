package javase03.t01;

/**
 * Created by rusamaha on 5/17/17.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("asd asd asd asd asd ");
        Thread.currentThread().sleep(5000);
        crazyLogger.addMessage("ddddas asddddd ds sds");

        System.out.println(crazyLogger.sb.toString());
    }
}
