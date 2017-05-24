package javase02.t05;

import java.util.*;

/**
 * Created by rusamaha on 5/16/17.
 */
public class Solution {
    public static void main(String[] args) {
//        List<Student> studentList = new ArrayList<>(Arrays.asList(
//                new Student("Petya"), new Student("Vasya"), new Student("Vasya"), new Student("Vasya"))
//        );

        List<Student> studentList = generateStudents(100); // generate all Students

        List<RatingByDiscipline> groupsList = new ArrayList<>(); // empty list

        // Add random rating for all Students
        for (Discipline discipline: Discipline.values()) {
            RatingByDiscipline group = new RatingByDiscipline(discipline);

            Random randomizer = new Random();
            int amountOfStudents = randomizer.nextInt(studentList.size()); // random amount of student for each Discipline

            for(int j = 0; j<amountOfStudents; j++){
                int idxOfStudent = randomizer.nextInt(studentList.size());

                group.setStudentRating(studentList.get(idxOfStudent), 100*randomizer.nextDouble());
//                group.setStudentRating(studentList.get(idxOfStudent), Arrays.asList(0.5, 10.0));
            }
            groupsList.add(group);
        }



        /// View all Students from list of RatingByDiscipline by Discipline
        for(RatingByDiscipline gd: groupsList){
            System.out.println(gd.getDiscipline());
            gd.getStudentRating().forEach((student, rating) -> System.out.println(student.getName() + " " + rating));
            System.out.println();
        }

        for(RatingByDiscipline gd: groupsList){
            System.out.printf("Top Students in %s are: \n", gd.getDiscipline()  );
            gd.topNStudents(10);
        }
    }



    static List<Student> generateStudents(int n){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            studentList.add(new Student("Student number" + i));
        }

        return studentList;
    }
}
