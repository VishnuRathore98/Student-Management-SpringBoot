package com.example.students;

import com.example.students.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentsApplication.class, args);

        Student student = context.getBean(Student.class);

        student.setRollNumber(1);
        student.setName("Jonathan");
        student.setMarks(67.32);

        System.out.println(student);
	}

}
