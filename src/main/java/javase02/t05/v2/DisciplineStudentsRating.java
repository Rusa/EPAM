package javase02.t05.v2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rusamaha on 5/17/17.
 */
 public class DisciplineStudentsRating {
    private Discipline discipline;
    private Map<Student, List<Double>> studentsRating = new HashMap<>();
    public DisciplineStudentsRating(Discipline discipline) {
        this.discipline = discipline;
    }

    public Map<Student, List<Double>> getStudentsRating() {
        return studentsRating;
    }

    void addStudent(Student student) {
        this.studentsRating.put(student, new ArrayList<>());
    }

    /// Add new mark for student
    public <T extends Number> void addMarkToStudent(Student student, T rating) {
        this.studentsRating.get(student).add(rating.doubleValue());
    }

    public List<Double> getRatingByStudent(Student student) {
        return this.studentsRating.get(student);
    }

    public Double getFinalRatingByStudent(Student student) {
        return this.studentsRating.get(student).stream().reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();
    }

    public Map<Student, Double> getAllStudentsFinalRating() {
        Map<Student, Double> studentRatingMap = new LinkedHashMap<>();
        for (Map.Entry<Student, List<Double>> e : studentsRating.entrySet()) {
            studentRatingMap.put(e.getKey(), getFinalRatingByStudent(e.getKey()));
        }
        return studentRatingMap;
    }

    public Map<Student, List<Double>> getAllStudentsRating() {
        return studentsRating;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public List<Map.Entry<Student, Double>> topNStudents(int n) {
        return getAllStudentsFinalRating().entrySet()
                .stream().sorted((o1, o2) -> -o1.getValue().compareTo(o2.getValue())).limit(n)
                .collect(Collectors.toList());
    }
    public List<Map.Entry<Student, List<Double>>> topNStudents2(int n) {
        return studentsRating.entrySet().stream()
                .sorted((o1, o2) -> new RatingComparator().compare(o1.getValue(), o2.getValue()))
                .limit(n).collect(Collectors.toList());
    }
    public Double overallRatingByDis() {
        return null;
    }

    public class RatingComparator implements Comparator<List<Double>> {
        @Override
        public int compare(List<Double> o1, List<Double> o2) {
            return -(o1.stream().reduce(0.0, (d1, d2) -> d1 + d2)).compareTo(o2.stream().reduce(0.0, (d1, d2) -> d1 + d2));
        }
    }
}






