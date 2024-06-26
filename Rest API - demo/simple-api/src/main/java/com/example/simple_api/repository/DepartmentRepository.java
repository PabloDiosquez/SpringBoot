package com.example.simple_api.repository;

import com.example.simple_api.entity.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    //List<Department> findByName(String name);
    List<Department> findByNameIgnoreCase(String name);
    Department findByCode(String code);
    @Modifying
    @Transactional
    @Query("DELETE FROM Department d WHERE d.code = :code")
    void deleteByCode(@Param("code") String code);
}
