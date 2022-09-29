package com.jdbc.bootjdbcexample.Dao;

import com.jdbc.bootjdbcexample.Modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    UserDao() {

    }
    //Create Table
    public int createTable() {
        String query = "Create table if not exists User(id int primary key,name varchar(10),age int, city varchar(10))";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    //Insert Values
    public int insertValues(User user) {
//        String query = "Insert into User values('"+user.getId()+"','"+user.getName()+"','"+user.getAge()+"','"+user.getCity()+"')";
        String query = "Insert into User values(?,?,?,?)";
//        int status = jdbcTemplate.update(query);
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setInt(3,user.getAge());
            preparedStatement.setString(4,user.getCity());;
        });
        return status;

    }

    //Deletes values
    public int deleteById(int id) {
        String query = "Delete from User where id='"+id+"')";
        int status = jdbcTemplate.update(query);
        return status;
    }

    //Select All values
    public List<User> selectAll(){
        String query = "Select * from User";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(User.class));
    }

    //Deletes All values
    public int deleteAll(){
        String query = "Delete from user";
        int status = jdbcTemplate.update(query);
        return status;
    }

    //Updates values
    public int updateById(int id,User user){
        String query = "update User" +
                " set name='"+user.getName()+"',id='"+user.getId()+"',age='"+user.getAge()+"',city='"+user.getCity()+"' where id='"+user.getId()+"' ";
        return jdbcTemplate.update(query);
    }

    //Select By ID
    public User selectById(int id){

        String query = "select * from user where id='"+id+"'";
//        List<User> userList = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(User.class));
        User userList = jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(User.class));
        if(userList==null){
            return null;

        }
        return userList;
    }

}
