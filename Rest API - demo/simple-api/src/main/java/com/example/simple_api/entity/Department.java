package com.example.simple_api.entity;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.function.Consumer;

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

    public static void copy(Department oldie, Department current) {
        copyIfNotBlank(current.getName(), oldie::setName);
        copyIfNotBlank(current.getAddress(), oldie::setAddress);
        copyIfNotBlank(current.getCode(), oldie::setCode);
    }

    private static void copyIfNotBlank(String value, Consumer<String> setter) {
        if (StringUtils.isNotBlank(value)) {
            setter.accept(value);
        }
    }

}
