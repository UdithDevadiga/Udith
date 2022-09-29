package com.robosoft.online_strore.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shopping_Cart {
    private int user_id;
    private int book_id;
    private double price;
}
