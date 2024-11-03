package com.ra.demo02.module.repository;

import com.ra.demo02.module.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    List<Employees> findByFullNameContainingIgnoreCase(String fullName);

}
