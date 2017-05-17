package javase02.t04;

import javase02.t02.stationery.Stationery;
import javase02.t03.StationeryKits;

import java.util.Comparator;
import java.util.List;

/**
 * Created by rusamaha on 5/14/17.
 */

//Используйте “набор новичка”, созданный в задании 3, (или любую другую коллекцию объектов);
// отсортируйте вещи в этом наборе по стоимости, по наименованию, по стоимости и наименованию.


public class Solution {
    private static final Comparator<Stationery> compareByCost = (o1, o2) -> (o1.getCost() - o2.getCost());//TODO:final

    private static final Comparator<Stationery> compareByName = (o1, o2) -> o1.getName().compareTo(o2.getName());//TODO:final

    private static final BiComparator costAndNameComparator = new BiComparator(compareByCost, compareByName);//TODO:final

    public static void main(String[] args) {

        List<Stationery> listPro = StationeryKits.stationeryKit(StationeryKits.KitType.PROFESSIONAL);

        listPro.sort(compareByCost);
        System.out.println(listPro);

        listPro.sort(compareByName);
        System.out.println(listPro);

        listPro.sort(costAndNameComparator);
        System.out.println(listPro);
    }
}

class BiComparator implements Comparator<Stationery> {
    private final Comparator<Stationery> cmp1;//TODO:final
    private final Comparator<Stationery> cmp2;//TODO:final

    public BiComparator(Comparator<Stationery> cmp1, Comparator<Stationery> cmp2) {
        this.cmp1 = cmp1;
        this.cmp2 = cmp2;
    }

    @Override
    public int compare(Stationery o1, Stationery o2) {
        int res = cmp1.compare(o1, o2);
        if (res == 0) {
            return cmp2.compare(o1, o2);
        }
        return res;
    }
}

