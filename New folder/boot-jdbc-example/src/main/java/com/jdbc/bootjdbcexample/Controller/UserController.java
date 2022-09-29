package com.jdbc.bootjdbcexample.Controller;

import com.jdbc.bootjdbcexample.Modal.User;
import com.jdbc.bootjdbcexample.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("/createTable")
    public int createTable(){
        return userDao.createTable();
    }

    @PostMapping("/insertValues")
    public int insertValues(@RequestBody User user){
        return userDao.insertValues(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id){
        return userDao.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public int deleteAll(){
        return userDao.deleteAll();
    }

    @PutMapping("/updateById/{id}")
    public int updateById(@PathVariable int id,@RequestBody User user){
        return userDao.updateById(id,user);
    }

    @GetMapping("/selectAll")
    public List<User> selectAll(){
        return userDao.selectAll();
    }

    @GetMapping("/selectById/{id}")
    public User selectById(@PathVariable int id){
        return userDao.selectById(id);
    }

}
