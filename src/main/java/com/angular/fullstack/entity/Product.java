package com.angular.fullstack.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String sku;
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal unit_price;
    @Column
    private String image_url;
    @Column
    private long units_in_stock;
    @Column
    private boolean active;
    @Column
    @CreationTimestamp
    private Date date_created;
    @Column
    @UpdateTimestamp
    private Date last_updated;
}
