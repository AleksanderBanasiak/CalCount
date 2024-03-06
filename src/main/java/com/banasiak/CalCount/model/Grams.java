package com.banasiak.CalCount.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grams")
public class Grams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gramsId;

    private double givenGrams;

    @ManyToOne
    private Product product;

}
