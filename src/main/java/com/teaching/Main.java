package main.java;

import com.teaching.college.CollegeDaoImpl;
import com.teaching.college.CollegeService;
import com.teaching.course.CourseDaoImpl;
import com.teaching.course.CourseService;
import com.teaching.grade.GradeDaoImpl;
import com.teaching.grade.GradeService;
import com.teaching.student.StudentDaoImpl;
import com.teaching.student.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(new StudentDaoImpl());
        CollegeService collegeService = new CollegeService(new CollegeDaoImpl());
        CourseService  courseService  = new CourseService(new CourseDaoImpl());
        GradeService   gradeService   = new GradeService(new GradeDaoImpl());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== 教学管理系统 =====");
            System.out.println("1. 学生管理");
            System.out.println("2. 学院管理");
            System.out.println("3. 课程管理");
            System.out.println("4. 成绩管理");
            System.out.println("0. 退出");
            System.out.print("请选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: studentService.menu(sc); break;
                case 2: collegeService.menu(sc); break;
                case 3: courseService.menu(sc);  break;
                case 4: gradeService.menu(sc);   break;
                case 0: System.out.println("再见！"); return;
                default: System.out.println("无效选项");
            }
        }
    }
}