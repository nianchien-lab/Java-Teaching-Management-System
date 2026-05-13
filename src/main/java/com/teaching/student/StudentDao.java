package main.java.com.teaching.student;

import java.util.*;

public interface StudentDao {
    void add(Student student);
    void delete(int id);
    void update(Student student);
    Student findById(int id);
    List<Student> findALL();
}
