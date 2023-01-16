package org.example.Student.repository.impl;

import org.example.Student.pojo.Student;
import org.example.Student.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<String, Student> map = new HashMap<String, Student>();

    @PostConstruct
    public void init(){
        map.put("1", new Student("1","Tom", new Date(), true));
        map.put("2", new Student("2","Jerry", new Date(), false));
    }
    @Override
    public Student find(String id){
        return map.get(id);
    }

    @Override
    public Collection<Student> findAll(){
        return map.values();
    }

    @Override
    public void remove(String id){map.remove(id);}

    @Override
    public void add(Student student){map.put(String.valueOf(map.size()+1), student);}

    /**
     * 1.impl Student + Teacher rest api : CRUD
     * 2.handle global exception @ControllerAdvice + @ExceptionHandler
     * 3.rest api design in readme
     */
}
