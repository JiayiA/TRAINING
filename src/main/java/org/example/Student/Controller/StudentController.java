package org.example.Student.Controller;

import org.example.Student.exception.ControllerExceptionHandler;
import org.example.Student.pojo.Student;
import org.example.Student.pojo.dto.StudentResponseDTO;
import org.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController{

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponseDTO> getStu(@RequestParam(required = false) String name){
        return new ResponseEntity<>(service.getAllStu(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO.StudentDTO> getStuById(@PathVariable String id){
        return new ResponseEntity<>(service.getStuById(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO.StudentDTO> createStu(@RequestBody Student student){
        return new ResponseEntity<>(service.createStu(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDTO.StudentDTO> deleteStu(@RequestBody String id){
        return new ResponseEntity<>(service.deleteStu(id), HttpStatus.OK);
    }

    @ExceptionHandler(ControllerExceptionHandler.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>("xxx not found", HttpStatus.NOT_FOUND);
    }

}