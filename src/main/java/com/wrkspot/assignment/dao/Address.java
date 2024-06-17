package com.wrkspot.assignment.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
