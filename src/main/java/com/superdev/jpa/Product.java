package com.superdev.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
public class Product {

    @Builder
    public Product(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;


}
