package org.example.Student.pojo.dto;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.Student.pojo.Student;

import java.util.List;

public class StudentResponseDTO {
    private List<StudentDTO> studentList;

    public StudentResponseDTO(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class StudentDTO{
        private String name;
        private String id;

        public StudentDTO(Student s) {
            this.name = s.getName();
            this.id = s.getId();
        }

    }


}
