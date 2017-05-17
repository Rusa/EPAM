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

        List<GroupByDiscipline> groupsList = new ArrayList<>();

        for (Discipline discipline: Discipline.values()) {
            GroupByDiscipline group = new GroupByDiscipline(discipline);

            Random randomizer = new Random();
            int amountOfStudents = randomizer.nextInt(studentList.size());

            for(int j = 0; j<amountOfStudents; j++){
                int idxOfStudent = randomizer.nextInt(studentList.size());

                group.setStudentRating(studentList.get(idxOfStudent), 100*randomizer.nextDouble());
            }
            groupsList.add(group);
        }

        /// View all Students from list of GroupByDiscipline by Discipline

        for(GroupByDiscipline gd: groupsList){
            System.out.println(gd.getDiscipline());
            gd.getStudentRating().forEach((student, rating) -> System.out.println(student.getName() + " " + rating));
            System.out.println();
        }

//        topTenStudents()

    }

    static Student[] topTenStudents(List<GroupByDiscipline> groupsList){
        groupsList.forEach(group -> {
            System.out.println(group.getDiscipline());
//            Collections.sort(group.getStudentRating(), new Comparator<T>() {
//                @Override
//                public int compare(T o1, T o2) {
//                    return 0;
//                }
//            });
//            group.getStudentRating().forEach();
        });
        return null;
    }

    static List<Student> generateStudents(int n){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            studentList.add(new Student("Student number" + i));
        }

        return studentList;
    }
}
