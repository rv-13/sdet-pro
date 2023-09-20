package com.utils.lambok;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // enable default consgtructor of the class withn no params
@AllArgsConstructor // use of all the fields while making the class object
@ToString // string representation of ur class fields
@Builder // build bean of ur class without passing all fields through constructor
public class Student {
    private String firstName;
    private boolean isGoodStudent;

}
