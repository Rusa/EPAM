package javase02.t05.v2;

/**
 * Created by rusamaha on 5/16/17.
 */
public enum Discipline {
    MATHEMATICS(true), ROBOTICS(true), AI(false), PERFORMANCE(true), NETWORKS(true), HISTORY(false), STATISTICS(false);

    boolean isMarkDouble;

    Discipline(boolean isMarkDouble){
        this.isMarkDouble = isMarkDouble;
    }

    public boolean isMarkDouble() {
        return isMarkDouble;
    }
}


