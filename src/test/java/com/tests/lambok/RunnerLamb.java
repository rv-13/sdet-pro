package com.tests.lambok;

import com.utils.lambok.Student;

public class RunnerLamb {
    public static void main(String[] args) {

        Student student = new Student();
        student.setGoodStudent(true);
        student.setFirstName("dddddd");
//        System.out.println(student);
        Student ravii = Student.builder().isGoodStudent(true).firstName("Ravii").build();
        System.out.println(ravii);
    }
}
