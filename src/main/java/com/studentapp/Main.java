package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Student> studentList;
    static void main() {
        System.out.println("*************************STUDENT MANAGEMENT SYSTEM*************************");
        System.out.println("***************************WELCOME****************************");

        studentList = new ArrayList<>();

        Student s1 = new Student("Sneha", 32, "S-1");
        s1.enrollCourse("Science");
        s1.enrollCourse("Sci-fi");
        s1.enrollCourse("devops");
        s1.printStudentInfo();

        Student s2 = new Student("Amar", 33, "S-11");
        s2.enrollCourse("java");
        s2.enrollCourse("java");
        s2.enrollCourse("C##");
        s2.enrollCourse("dsa");
        s2.printStudentInfo();

        Student s3 = new Student("Bittuu", 20, "S-03");
        s3.enrollCourse("java");
        s3.enrollCourse("java");
        s3.enrollCourse("C##");
        s3.enrollCourse("dsa");
        s3.printStudentInfo();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Student result = findStudentById("S-45");
        System.out.println("RESULT - "+result);

        sortByName();
    }

    public static Student findStudentById(String studentId){
        Student result = null;
        try {
            result = studentList.stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found"));
        }catch(RuntimeException e){
            System.err.println("StudentId "+studentId+" not found!!");
        }
        return result;
    }
    private static void sortByName() {
        Comparator<Student> studentNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
    }
}
