package com.andreev.StadyJavaEE.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {
    private Long id;
    private String name;
    private String shortName;
}
