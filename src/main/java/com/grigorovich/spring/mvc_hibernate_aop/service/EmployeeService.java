package com.grigorovich.spring.mvc_hibernate_aop.service;

import com.grigorovich.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(); //метод называем также как в EmployeeDAO

    void saveEmployee(Employee employee); //метод сохранения работника в базу данных

    Employee getEmployee(int id); //получаем работника по id

    void deleteEmployee(int id);
}
