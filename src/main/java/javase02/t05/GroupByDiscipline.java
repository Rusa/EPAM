package javase02.t05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rusamaha on 5/17/17.
 */
public class GroupByDiscipline {
    private Discipline discipline;
    private Map<Student, Double> studentRating = new HashMap<>();

    public GroupByDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setStudentRating(Student studentRating, Double rating) {
        this.studentRating.put(studentRating, rating);
    }

    public Map<Student, Double> getStudentRating() {
        return studentRating;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}



