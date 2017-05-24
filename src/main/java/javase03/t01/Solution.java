package javase03.t01;

/**
 * Created by rusamaha on 5/17/17.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("asd arusamahasd asd asd asd ");

        crazyLogger.addMessage("ddddas asddddd ds sds");

        crazyLogger.addMessage("ddddas asddddd ds sdsasdasd asd asd asd 21-04  rusa>|||-_-");

        crazyLogger.addMessage("ddddas asrusadd mahads sds");

        crazyLogger.addMessage("ddddas asddddd rusamaha ds sds");

        crazyLogger.showLog();

        crazyLogger.search("rusamaha");

    }
}
