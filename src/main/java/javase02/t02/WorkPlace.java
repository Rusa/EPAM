package javase02.t02;

import javase02.t02.stationery.*;

import java.util.List;

/**
 * Created by rusamaha on 5/14/17.
 */
public class WorkPlace {
    Employee employee;
    List<Stationery> stationery;

    public WorkPlace(Employee employee, List<Stationery> stationery) {
        this.employee = employee;
        this.stationery = stationery;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Stationery> getStationery() {
        return stationery;
    }

    public void setStationery(List<Stationery> stationery) {
        this.stationery = stationery;
    }
}
