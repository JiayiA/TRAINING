package org.example.Student.pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    @JsonIgnore
    private Date lastActiveDate;
    @Column
    @JsonIgnore
    private boolean isActive;

    public Student() {
    }

    public Student(String id, String name, Date lastActiveDate, boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastActiveDate = lastActiveDate;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
