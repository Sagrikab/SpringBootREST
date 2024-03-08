package com.student.application.service;

import com.student.application.entities.Student;
import com.student.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, int rollNo) {
        Optional<Student> student1=studentRepository.findById(rollNo);

       if(student1.isPresent()){
           Student existingStudent = student1.get();

           if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
               existingStudent.setName(student.getName());
               return studentRepository.save(existingStudent);
           }
       }

       if(student1.isPresent()){
           Student existingStudent=student1.get();
           if(Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())){
               existingStudent.setAddress(student.getAddress());
               return studentRepository.save(existingStudent);
           }
       }
        if(student1.isPresent()){
            Student existingStudent=student1.get();
            if(Objects.nonNull(student.getMarks()) && !"".equalsIgnoreCase(String.valueOf(student.getMarks()))){
                existingStudent.setMarks(student.getMarks());
                return studentRepository.save(existingStudent);
            }
        }

        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
