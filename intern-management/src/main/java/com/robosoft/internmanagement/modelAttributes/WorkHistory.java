package com.robosoft.internmanagement.modelAttributes;

import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WorkHistory {

    private String company;
    private String position;
    private Date fromDate;
    private Date toDate;
    private String location;

}
