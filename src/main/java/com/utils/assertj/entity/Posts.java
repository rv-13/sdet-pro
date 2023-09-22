package com.utils.assertj.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Posts {

    private int id;
    private String title;
    private String author;

}
