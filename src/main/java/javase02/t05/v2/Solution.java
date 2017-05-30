package javase02.t05.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rusamaha on 5/16/17.
 */
public class Solution {
    public static void main(String[] args) {
        List<Student> studentList = generateStudents(50); // generate all Students
        List<DisciplineStudentsRating> groupsList = generateRatingForStudents(studentList);

        /// All groups with Students Final rating:
        System.out.println("//////////// All students //////////// ");
        groupsList.forEach(discStudsRating -> {
            int[] i = {0};
            System.out.println(discStudsRating.getDiscipline());
            discStudsRating.getAllStudentsFinalRating().forEach(
                    (student, rating) -> System.out.printf("%s) %s %2.2f \n", ++i[0], student.getName(), rating));
        });

        // Top N Students
        System.out.println("//////////// Top 5 students by Final Rating //////////// ");
        groupsList.forEach(discStudsRating -> {
            System.out.println(discStudsRating.getDiscipline());
            discStudsRating.topNStudents(5).forEach(o -> System.out.printf("%s %2.2f \n", o.getKey().getName(), o.getValue()));
        });

        System.out.println("//////////// Top 5 students by all marks //////////// ");
        groupsList.forEach(discStudsRating -> {
            System.out.println(discStudsRating.getDiscipline());
            discStudsRating.topNStudents2(5).forEach(o -> System.out.printf("%s %s \n", o.getKey().getName(), o.getValue()));
        });

        System.out.println("//////////// Find Student number 17");
        Student student = studentList.get(17);
        groupsList.forEach(discStudsRating -> {
                if (discStudsRating.getAllStudentsRating().containsKey(student))
                    System.out.printf("%s %2.2f %s \n", discStudsRating.getDiscipline(), discStudsRating.getFinalRatingByStudent(student), discStudsRating.getRatingByStudent(student));
            }
        );
    }

    // List of groups with Random rating for all Students
    private static List<DisciplineStudentsRating> generateRatingForStudents(List<Student> studentList) {
        // empty list
        List<DisciplineStudentsRating> groupsList = new ArrayList<>();

        for (Discipline discipline : Discipline.values()) {
            DisciplineStudentsRating group = new DisciplineStudentsRating(discipline);

            Random randomize = new Random();
            int amountOfStudents = randomize.nextInt(studentList.size()); // random amount of student for each Discipline

            for (int j = 0; j < amountOfStudents; j++) {

                int idxOfStudent = randomize.nextInt(studentList.size());
                Student student = studentList.get(idxOfStudent);
                group.addStudent(student);

                //Add 10 marks to each student with int and double rating(mark)
                for (int i = 0; i < 10; i++) {
                    Number mark = discipline.isMarkDouble() ? 10 * randomize.nextDouble() : randomize.nextInt(10);
                    group.addMarkToStudent(student, mark);
                }
            }
            groupsList.add(group);
        }
        return groupsList;
    }

    private static List<Student> generateStudents(int n) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            studentList.add(new Student("Student number" + i));
        }
        return studentList;
    }
}
