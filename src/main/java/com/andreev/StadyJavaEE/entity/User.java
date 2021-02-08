package com.andreev.StadyJavaEE.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;
}
