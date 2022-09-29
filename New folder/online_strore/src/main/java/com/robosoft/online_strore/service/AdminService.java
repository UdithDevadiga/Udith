package com.robosoft.online_strore.service;

import com.robosoft.online_strore.modal.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class AdminService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addBook(Books books) {
        String query =  "insert into books values('"+books.getBook_id()+"','"+books.getName()+"','"+books.getAuthor_name()+"','"+books.getPrice()+"')";
        return jdbcTemplate.update(query);
    }

    public int removeBooks() {
        String query =  "delete from books";
        return jdbcTemplate.update(query);
    }

    public int removeBookById(int id) {
        String query = "delete from books where book_id = '"+id+"'";
        return jdbcTemplate.update(query);
    }

    public List<Books> viewBooks(){
        String query = "select * from books";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Books.class));
    }

    public Books viewBookById(int id){
        String query = "select * from books where book_id = "+id;
        return jdbcTemplate.query(query,(resultSet)->{
            Books books = new Books();
            resultSet.next();
            books.setBook_id(resultSet.getInt(1));
            books.setName(resultSet.getString(2));
            books.setAuthor_name(resultSet.getString(3));
            books.setPrice(resultSet.getDouble(4));
            return books;
        });
    }

    public int increaseBookAmount(int id,double amount) {
        String query = "update books set price ="+amount+"where book_id ="+id;
        return jdbcTemplate.update(query);
    }
}
