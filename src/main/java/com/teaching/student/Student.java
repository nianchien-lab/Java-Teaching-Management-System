package main.java.com.teaching.student;

import Lombok.*;

@Data
@AllArgsConstructor

public class Student{
    private int id;
    private String name;
    private String gender;
    private int collegeId;
}