package com.library.library_system.repository;

import com.library.library_system.model.Loan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanRepository {

    @Select("SELECT l.*,b.id AS book_id,b.title AS book_title,b.isbn AS book_isbn,s.id AS student_id,s.name AS student_name,s.student_number AS student_number FROM loans l INNER JOIN books b ON b.id = l.book_id INNER JOIN students s ON l.student_id = s.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "book.id", column = "book_id"),
            @Result(property = "book.title", column = "book_title"),
            @Result(property = "book.isbn", column = "book_isbn"),
            @Result(property = "student.id", column = "student_id"),
            @Result(property = "student.name", column = "student_name"),
            @Result(property = "student.studentNumber", column = "student_number")
    })
    List<Loan> findAll();

    @Select("SELECT * FROM loans WHERE id = #{id}")
    Loan findById(Long id);

    @Insert("INSERT INTO loans (id, book_id, student_id, loan_date, return_date) VALUES (loan_seq.NEXTVAL, #{bookId}, #{studentId}, #{loanDate}, #{returnDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Loan loan);

    @Update("UPDATE loans SET book_id = #{bookId}, student_id = #{studentId}, loan_date = #{loanDate}, return_date = #{returnDate} WHERE id = #{id}")
    void update(Loan loan);

    @Delete("DELETE FROM loans WHERE id = #{id}")
    void delete(Long id);
}




