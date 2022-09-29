package com.robosoft.online_strore.service;

import com.robosoft.online_strore.modal.Books;
import com.robosoft.online_strore.modal.Purchase;
import com.robosoft.online_strore.modal.Shopping_Cart;
import com.robosoft.online_strore.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int register(User user) {
        String query = "insert into user values('"+user.getUser_id()+"','"+user.getName()+"')";
        return jdbcTemplate.update(query);
    }

    public List<Books> viewBooks(){
        String query = "select * from books";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Books.class));
    }

    public Books viewBookById(int id) {
        String query = "Select * from Books where book_id = "+id;
        List<Books> books= jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Books.class));
        return books.get(0);
    }

    public double getBookPrice(int book_id) {
        String query = "select price from books where book_id ="+book_id;
        return jdbcTemplate.queryForObject(query,Double.class);
    }
    public int addToCart(int user_id,int book_id) {
        double price = getBookPrice(book_id);
        String query = "insert into shopping_cart values('"+user_id+"','"+book_id+"','"+price+"')";
        return jdbcTemplate.update(query);
    }

    public int addToPurchase(int user_id,int book_id) {
        double price = getBookPrice(book_id);
        String query = "insert into purchase values("+user_id+","+book_id+","+price+")";
        String delQuery = "delete from shopping_cart where user_id = "+user_id+" and book_id = "+book_id;
        jdbcTemplate.update(delQuery);
        return jdbcTemplate.update(query);
    }

    public int removeAllFromCart(int user_id) {
        String query = "delete from shopping_cart where user_id = "+user_id;
        return jdbcTemplate.update(query);
    }

    public int removeFromCart(int user_id,int book_id) {
        String query = "delete from shopping_cart where user_id = "+user_id+" and book_id = "+book_id;
        return jdbcTemplate.update(query);
    }

    public List<Shopping_Cart> viewCart(int user_id) {
        String query = "Select * from shopping_cart where user_id = "+user_id;
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Shopping_Cart.class));
    }

    public Shopping_Cart viewCart(int user_id,int book_id) {
        String query = "Select * from shopping_cart where user_id = "+user_id+" and book_id = "+book_id;
        List<Shopping_Cart> shopping_carts = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Shopping_Cart.class));
        return shopping_carts.get(0);
    }
    public List<Purchase> viewPurchases(int user_id) {
        String query = "select * from purchase where user_id = "+user_id;
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Purchase.class));
    }

    public Purchase viewPurchase(int user_id,int book_id) {
            String query = "select * from purchase where user_id = " + user_id + " and book_id = " + book_id;
            List<Purchase> purchase = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Purchase.class));
            return purchase.get(0);
    }





}
