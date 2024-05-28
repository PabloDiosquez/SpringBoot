package com.example.simple_api.entity;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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

    @NotBlank(message = "The department's name can not be blank")
    @Length(max = 10, min = 1, message = "The number of characters must be between 1 and 10 inclusive")
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
