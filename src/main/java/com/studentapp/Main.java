package com.studentapp;

import java.util.*;

import static java.lang.System.exit;

public class Main {
    private static List<Student> studentList;
    private static Scanner scanner;
    static void main() {
        System.out.println("*************************STUDENT MANAGEMENT SYSTEM*************************");

        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("***************************WELCOME****************************");

            System.out.println("Select an Option");
            System.out.println("1. Register a student");
            System.out.println("2. Find Student with StudentId");
            System.out.println("3. List all student Information");
            System.out.println("4. List student info in sorted order");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                case 4:
                    sortByName();
                    break;
                case 5:
                    System.out.println("GOOD BYEEEEE!!!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid number selected. Select any number between 1 to 5");
            }
        }
    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(studentList, studentNameComparator);
        printAllStudentData();
    }

    private static void printAllStudentData() {
        if(studentList.size()>0){
            System.out.println("*********************** PRINT ALL STUDENT DATA **************************");
            for(Student student: studentList){
                student.printStudentInfo();
            }
        }else{
            System.err.println("Student list is EMPTY. No record found!!!");
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter Student name: ");
        String stdName = scanner.next();

        System.out.println("Enter Student age: ");
        int stdAge = scanner.nextInt();

        System.out.println("Enter Student studentId: ");
        String stdId = scanner.next();

        Student newStudentObj = new Student(stdName, stdAge, stdId);
        studentList.add(newStudentObj);

        while(true) {
            System.out.println("Enter course to be enrolled...Else type done.");
            String course = scanner.next();
            if(course.equalsIgnoreCase("done"))
                break;
            newStudentObj.enrollCourse(course);
        }

        newStudentObj.printStudentInfo();
    }
    private static void findStudentById(Scanner scanner) {
        Student result = null;
        System.out.println("Enter studentId");
        String studentId = scanner.next();
        try {
            result = studentList.stream().
                    filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).
                    findFirst().
                    orElseThrow(() -> new RuntimeException("No data found!!!"));
        }catch(RuntimeException e){
            System.err.println("StudentId "+studentId+" not found!!");
        }
        result.printStudentInfo();
    }
}
