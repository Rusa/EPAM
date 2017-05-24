package javase02.t05;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by rusamaha on 5/17/17.
 */
public class RatingByDiscipline {
    private Discipline discipline;
    private Map<Student, Double> studentRating = new HashMap<>();

    private Map<Student, List<Double>> studentRating2 = new HashMap<>(); //TODO

    public RatingByDiscipline(Discipline discipline) {
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

    public void topNStudents(int n) {

        studentRating.entrySet().stream()
                .sorted((o1, o2) -> (int) Math.round(o2.getValue() - o1.getValue()))
                .limit(n)
                .forEach(student -> System.out.println(student.getKey().getName() + " " + student.getValue()));
    }



    public Double overallRatingByDis(){
        return null;
    }

    public List<Map.Entry> topMStudents(int n) {

        //List<Map.Entry> topList = new ArrayList<>();

        return studentRating2.entrySet().stream()
                .sorted((o1, o2) -> new RatingComparator().compare(o1.getValue(), o2.getValue()))
                .limit(n).collect(Collectors.toList());
                //.forEach(student -> System.out.println(student.getKey().getName() + " " + student.getValue()));


//        studentRating2.entrySet()
//                .forEach(entry -> entry.getValue().stream().reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2));
//
//
//        studentRating2.entrySet().forEach(entry -> entry.getValue().stream().reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2));

    }


    public class RatingComparator implements Comparator<List<Double>> {
        @Override
        public int compare(List<Double> o1, List<Double> o2) {
            return (o1.stream().reduce(0.0, (d1, d2) -> d1 + d2)).compareTo(o2.stream().reduce(0.0, (d1, d2) -> d1 + d2));
        }
    }
}






