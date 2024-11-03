package com.ra.demo02.module.service;

import com.ra.demo02.module.entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
   Employees findById(long id);
   Employees save(Employees employees);
   void delete(Long id);
   List<Employees> findByName(String name);
}
