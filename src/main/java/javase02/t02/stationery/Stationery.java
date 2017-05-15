package javase02.t02.stationery;

import java.math.BigDecimal;

/**
 * Created by rusamaha on 5/13/17.
 */
public abstract class Stationery {
    private String name;
    private Integer cost;

    public Stationery(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {name='" + name + '\'' +
                ", cost=" + cost + '}';
    }
}
