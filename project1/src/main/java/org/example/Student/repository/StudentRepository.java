package org.example.Student.repository;

import org.example.Student.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository {
    Student find(String id);
    Collection<Student> findAll();
    void remove(String id);
    void add(Student student);
}
