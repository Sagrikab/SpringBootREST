package com.student.application.service;

import com.student.application.entities.Student;

import java.util.List;

public interface StudentService {

    //create
    Student addStudent(Student student);

    //read
    List<Student> getStudent();

    //update
    Student updateStudent(Student student,int id);

    //delete
    void deleteStudentById(int id);
}
