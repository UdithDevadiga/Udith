package com.robosoft.online_strore.controller;

import com.robosoft.online_strore.modal.Books;
import com.robosoft.online_strore.modal.Purchase;
import com.robosoft.online_strore.modal.Shopping_Cart;
import com.robosoft.online_strore.modal.User;
import com.robosoft.online_strore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/Register")
    public int register(@RequestBody User user) {
        return userService.register(user);
    }
    @GetMapping("/viewBooks")
    public List<Books> viewBooks() {
        return userService.viewBooks();
    }
    @GetMapping("/viewBook/{id}")
    public Books viewBook(@PathVariable int id){
        return userService.viewBookById(id);
    }
    @PostMapping("/addToCart/{user_id}/{book_id}")
    public int addToCart(@PathVariable int user_id,@PathVariable int book_id) {
        return userService.addToCart(user_id,book_id);
    }
    @PostMapping("/Buy/{user_id}/{book_id}")
    public int addToPurchase(@PathVariable int user_id,@PathVariable int book_id) {
        return userService.addToPurchase(user_id,book_id);
    }
    @DeleteMapping("/remove/{user_id}/{book_id}")
    public int removeFromCart(@PathVariable int user_id,@PathVariable int book_id) {
        return userService.removeFromCart(user_id,book_id);
    }
    @DeleteMapping("removeAll/{user_id}")
    public int removeAllFromCart(@PathVariable int user_id) {
        return userService.removeAllFromCart(user_id);
    }
    @GetMapping("/viewCart/{user_id}")
    public List<Shopping_Cart> viewCart(@PathVariable int user_id) {
        return userService.viewCart(user_id);
    }
    @GetMapping("/viewCart/{user_id}/{book_id}")
    public Shopping_Cart viewCart(@PathVariable int user_id,@PathVariable int book_id) {
        return userService.viewCart(user_id,book_id);
    }
    @GetMapping("viewPurchase/{user_id}/{book_id}")
    public Purchase viewPurchase(@PathVariable int user_id, @PathVariable int book_id) {
        return userService.viewPurchase(user_id,book_id);
    }
    @GetMapping("viewPurchases/{user_id}")
    public List<Purchase> viewPurchases(@PathVariable int user_id) {
        return userService.viewPurchases(user_id);
    }
}
