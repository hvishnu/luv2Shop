package com.angular.fullstack.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name="state")
@Data
public class State {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}
