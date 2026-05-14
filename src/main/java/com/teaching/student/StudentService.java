package main.java.com.teaching.student;

import Lombok.*;

import java.security.Provider.Service;
import java.util.*;

@RequiredArgsConstructor

public class StudentService {
    private final StudentDao dao;
    private int nextId = 1;
    
    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- 学生管理 ---");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查询所有学生");
            System.out.println("0. 返回");
            System.out.print("请选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(sc);    break;
                case 2: deleteStudent(sc); break;
                case 3: updateStudent(sc); break;
                case 4: listAll();         break;
                case 0: return;
                default: System.out.println("无效选项");
            }
        }
    }

    private void addStudent(Scanner sc) {
        System.out.print("姓名：");        String name      = sc.next();
        System.out.print("性别（男/女）："); String gender    = sc.next();
        System.out.print("学院ID：");      int    collegeId = sc.nextInt();
        dao.add(new Student(nextId++, name, gender, collegeId));
        System.out.println("添加成功");
    }

    private void deleteStudent(Scanner sc) {
        System.out.print("请输入学生ID：");
        dao.delete(sc.nextInt());
        System.out.println("删除成功");
    }

    private void updateStudent(Scanner sc) {
        System.out.print("请输入要修改的学生ID：");
        Student s = dao.findById(sc.nextInt());
        if (s == null) { System.out.println("学生不存在"); return; }
        System.out.print("新姓名：");   s.setName(sc.next());
        System.out.print("新性别：");   s.setGender(sc.next());
        System.out.print("新学院ID："); s.setCollegeId(sc.nextInt());
        dao.update(s);
        System.out.println("修改成功");
    }

    private void listAll() {
        List<Student> list = dao.findAll();
        if (list.isEmpty()) { System.out.println("暂无学生记录"); return; }
        list.forEach(System.out::println);
    }
}

