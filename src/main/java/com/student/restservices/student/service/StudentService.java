package com.student.restservices.student.service;

import com.student.restservices.student.model.Student;
import com.student.restservices.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
    public Student getStudentById(int id){
     // return studentRepository.findById(id);
        Student s = studentRepository.findById(id).get();
        return s;
    }
    public Student addStudent(Student student){
     return studentRepository.save(student);
    }
    public void updateStudent(int id,Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

}
