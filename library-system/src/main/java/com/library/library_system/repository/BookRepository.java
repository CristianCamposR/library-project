package com.library.library_system.repository;

import com.library.library_system.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookRepository {
    @Select("SELECT * FROM books")
    List<Book> findAll();
    @Select("SELECT * FROM books WHERE id = #{id}")
    Book findById(Long id);

    @Insert("INSERT INTO books (id, title, author, isbn, quantity, available) VALUES (book_seq.NEXTVAL, #{title}, #{author}, #{isbn}, #{quantity}, #{available})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Book book);

    @Update("UPDATE books SET title = #{title}, author = #{author}, isbn = #{isbn}, quantity = #{quantity}, available = #{available} WHERE id = #{id}")
    void update(Book book);

    @Update("UPDATE books SET available = available - 1 WHERE id = #{id} AND available > 0")
    int decrementAvailable(Long id);

    @Update("UPDATE books SET available = available + 1 WHERE id = #{id} AND available < quantity")
    int incrementAvailable(Long id);

    @Delete("DELETE FROM books WHERE id = #{id}")
    void delete(Long id);
}
