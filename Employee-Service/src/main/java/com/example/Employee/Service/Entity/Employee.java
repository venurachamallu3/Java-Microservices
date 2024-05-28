package com.example.Employee.Service.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private String name;
    private  String address;
    @Column(nullable = false, unique = true)
    private  String email;
    private String departmentCode;
}
