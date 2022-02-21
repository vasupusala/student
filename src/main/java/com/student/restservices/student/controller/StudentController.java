package com.student.restservices.student.controller;

import com.student.restservices.student.errorhandlers.StudentNotFoundException;
import com.student.restservices.student.model.Student;
import com.student.restservices.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
   @Autowired
    private StudentService studentService;

   @GetMapping("/students")
    public List<Student> getAllStudents(){
       return studentService.getAllStudents();
   }

   @PostMapping("/students")
    public ResponseEntity<Student> addStudent( @Valid @RequestBody Student student){
    Student studentCreate = studentService.addStudent(student);
    return new ResponseEntity<Student>(studentCreate, HttpStatus.CREATED);
   }

   @GetMapping("/students/{id}")
   public  ResponseEntity<Student>  getStudentById(@PathVariable int id){
       Student student = studentService.getStudentById(id);
     // return studentService.getStudentById(id);
       if(student == null) {
           return new ResponseEntity<Student>(student, HttpStatus.NOT_FOUND);
       }else{
           return new ResponseEntity<Student>(student,HttpStatus.OK);
       }
   }
   @PutMapping("students/{id}")
   public void updateStudent(@RequestBody Student student,@PathVariable int id){
       studentService.updateStudent(id,student);
   }
   @DeleteMapping("students/{id}")
   public void deleteStudent(@PathVariable int id){

       studentService.deleteStudent(id);
   }

}
