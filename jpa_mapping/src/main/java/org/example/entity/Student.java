package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    @OneToOne
    @JoinColumn(name = "laptop_id", unique = true)
    @ToString.Exclude
    private Laptop laptop;
}