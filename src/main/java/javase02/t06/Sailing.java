package javase02.t06;

/**
 * Created by rusamaha on 5/13/17.
 */

public class Sailing {
    public static void main(String[] args) throws InterruptedException {
        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine();
        nuclearSubmarine.GoToSailing();
        Thread.sleep(1000);
        nuclearSubmarine.stop();

    }
}
