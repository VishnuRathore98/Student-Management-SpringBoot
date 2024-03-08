package com.example.students;

import com.example.students.model.Student;
import com.example.students.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentsApplication.class, args);

        Student student = context.getBean(Student.class);

        student.setRollNumber(104);
        student.setName("Jonathan");
        student.setMarks(67);


        StudentService service = context.getBean(StudentService.class);
        service.addStudent(student);

        List<Student> studentList = service.getStudents();
        System.out.println(studentList);
	}

}
