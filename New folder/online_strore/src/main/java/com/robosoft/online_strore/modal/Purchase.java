package com.robosoft.online_strore.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private int user_id;
    private int book_id;
    private double price;
}
