package com.robosoft.insurance.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participated {
   private String driver_id;
   private String regno;
   private int report_number;
   private int damage_amount;
}
