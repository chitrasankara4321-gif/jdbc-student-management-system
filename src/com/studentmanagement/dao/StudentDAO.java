package com.studentmanagement.dao;

import com.studentmanagement.model.Student;

public interface StudentDAO {

    void addStudent(Student s);

    void viewStudents();

    void updateStudent(int id, double marks);

    void deleteStudent(int id);
}