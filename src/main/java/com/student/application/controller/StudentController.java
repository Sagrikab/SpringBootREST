package com.student.application.controller;

import com.student.application.entities.Student;
import com.student.application.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        Student student1=studentService.addStudent(student);
        logger.info("student is added successfully");
        return student1;
    }

    @GetMapping("/getStudent")
    public List<Student> getAllStudent(){
        return studentService.getStudent();
    }

    @PutMapping("/updateStudent/{rollNo}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("rollNo") int rollNo){
        logger.info("we are updating the data of student");
        return studentService.updateStudent(student,rollNo);
    }

    @DeleteMapping("/deleteById/{rollNo}")
    public void deleteStudentById(@PathVariable("rollNo") int rollNo){
        studentService.deleteStudentById(rollNo);
        logger.info("Student deleted successfully");
    }

}
