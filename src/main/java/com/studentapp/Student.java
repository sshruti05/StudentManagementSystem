package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); // Initialization of courses
        }
    }
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public List<String> getCourses() {
        return courses;
    }

    public void enrollCourse(String course){
        if(validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student enrolled to " + course + " successfully!");
            } else {
                System.err.println("Student has already enrolled for " + course);
            }
        }
    }

    public void printStudentInfo(){
        System.out.println("_______________________ Student Info _______________________");
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("Student StudentId: "+studentId);
        System.out.println("Enrolled for Courses: "+courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public boolean validateAge(int age){
        if(age>18 && age<36){
            return true;
        }else{
            System.err.println("Invalid Age!!");
            return false;
        }
    }

    public boolean validateName( String name){
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatches = namePattern.matcher(name);
        if(nameMatches.matches())
            return true;
        else {
            System.err.println("Invalid Name!!!");
            return false;
        }
    }
    private boolean validateStudentId(String studentId) {
        String studentRegex = "S-\\d+$";
        Pattern studentPattern = Pattern.compile(studentRegex);
        Matcher studentMatcher = studentPattern.matcher(studentId);
        if(studentMatcher.matches())
            return true;
        else{
            System.err.println("Invalid StudentId!!!");
            return false;
        }
    }
    public boolean validateCourseName(String course){
        if(course.equalsIgnoreCase("Java")|| course.equalsIgnoreCase("DSA")|| course.equalsIgnoreCase("DevOps")){
            return true;
        }
        else {
            System.err.println("Invalid Courses!!!");
            return false;
        }
    }

}
