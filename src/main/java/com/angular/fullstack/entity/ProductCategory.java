package com.angular.fullstack.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name="product_category")
@Entity
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String category_name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set <Product> products;
}
