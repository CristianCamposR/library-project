package com.library.library_system.repository;

import com.library.library_system.model.Loan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanRepository {

    @Select("SELECT * FROM loans")
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
