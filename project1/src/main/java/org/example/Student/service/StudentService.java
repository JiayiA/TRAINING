package org.example.Student.service;

import org.example.Student.StudentApplication;
import org.example.Student.pojo.Student;
import org.example.Student.pojo.dto.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO getAllStu();
    StudentResponseDTO.StudentDTO getStuById(String id);
    StudentResponseDTO.StudentDTO createStu(Student student);
    StudentResponseDTO.StudentDTO deleteStu(String id);
}
