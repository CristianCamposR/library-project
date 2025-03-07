package com.library.library_system.repository;

import com.library.library_system.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students")
    List<Student> findAll();
    @Insert("INSERT INTO students (id, name, student_number, email, phone) VALUES (student_seq.NEXTVAL, #{name}, #{studentId}, #{student_number}, #{email}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Student student);
}
