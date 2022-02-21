package com.student.restservices.service;

import com.student.restservices.student.model.Student;
import com.student.restservices.student.repository.StudentRepository;
import com.student.restservices.student.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;
    @Test
    public void studentServiceTest(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Student(1001,"Johnuy",2000,"IT")));
       List<Student> students =  studentService.getAllStudents();
    }
}
