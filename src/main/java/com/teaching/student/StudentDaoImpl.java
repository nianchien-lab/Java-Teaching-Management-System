package main.java.com.teaching.student;

import java.util.*;

public class StudentDaoImpl {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student){
        students.add(student);
    }

    @Override
    public void delete(int id){
        students.removeIf(s -> s.getId() == id);
    }

    @Override
    public void update(Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==student.getId()){
                students.set(i,student);
                return;
            }
        }
    }

    @Override
    public Student findById(int id){
        return students.stream().filter(s -> s.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll(){
        return new ArrayList<>(students);
    }
}
