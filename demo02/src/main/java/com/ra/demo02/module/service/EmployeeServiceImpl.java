package com.ra.demo02.module.service;

import com.ra.demo02.module.entity.Employees;
import com.ra.demo02.module.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees findById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employees save(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employees> findByName(String name) {
        return employeeRepository.findByFullNameContainingIgnoreCase(name);
    }
}
