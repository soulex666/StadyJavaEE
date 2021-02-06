package com.andreev.StadyJavaEE.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private Long id;
    private String name;
    private int price;
    private int amount;
    private Country manufacturer;
}
