package javase02.t01;

/**
 * Created by rusamaha on 5/14/17.
 */
public class Solution {
    public static void main(String[] args) {
        Pen p = new Pen("Parker", "President", "BR171771", Pen.PenType.BALLPOINT, Pen.Material.METAL, "black", 1, 20.0f, "President pen", 2000);
        System.out.println(p);
    }
}
