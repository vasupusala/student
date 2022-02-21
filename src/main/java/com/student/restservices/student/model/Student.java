package com.student.restservices.student.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    private int id;
    @Size(min = 2,message = "Name should have atleast 2 chracters")
    private String name;
    @NotNull
    private int salary;
    @NotNull
    private String dept;

    public Student(){

    }

    public Student(int id, String name, int salary, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
