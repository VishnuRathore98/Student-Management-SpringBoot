package com.example.students.repository;

import com.example.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student){
        String sqlInsertQuery="INSERT INTO students (sid, sname, marks) VALUES(?, ?, ?)";

        int rows = jdbcTemplate.update(sqlInsertQuery, student.getRollNumber(), student.getName(), student.getMarks());
        System.out.println(rows+" row affected...");
    }

//  findAll() with RowMapper.
/*
    public List<Student> findAll(){

        String sqlSelectQuery = "SELECT * FROM student";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRollNumber(rs.getInt("rollNumber"));
                student.setName(rs.getString("studentName"));
                student.setMarks(rs.getInt("marks"));

                return student;
            }
        };

        return jdbcTemplate.query(sqlSelectQuery,mapper);
    }
*/

public List<Student> findAll(){

    String sqlSelectQuery = "SELECT * FROM students";

//    Lambda expression
/*
    RowMapper<Student> mapper = (ResultSet rs, int rowNum) -> {
            Student student = new Student();
            student.setRollNumber(rs.getInt("rollNumber"));
            student.setName(rs.getString("studentName"));
            student.setMarks(rs.getInt("marks"));

            return student;
    };
*/

//  Inline lambda expression
    return jdbcTemplate.query(sqlSelectQuery, (ResultSet rs, int rowNum) -> {
        Student student = new Student();
        student.setRollNumber(rs.getInt("sid"));
        student.setName(rs.getString("sname"));
        student.setMarks(rs.getInt("marks"));

        return student;
    });
}
}