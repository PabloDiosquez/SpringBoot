package com.example.simple_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    public static Department copy(Department oldie, Department current){
        oldie.setName(current.getName());
        oldie.setAddress(current.getAddress());
        oldie.setCode(current.getCode());
        return oldie;
    }
}
