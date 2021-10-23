package com.grigorovich.spring.mvc_hibernate_aop.controller;

import com.grigorovich.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.grigorovich.spring.mvc_hibernate_aop.entity.Employee;
import com.grigorovich.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //компонент
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) { //модель нужна для того чтобы во вью можно было передать список работников
        List<Employee> allEmployees=employeeService.getAllEmployees();
        model.addAttribute("allEmp", allEmployees);
        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee=new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) { //мы должны получить из формы работника, КОТОРГО СОЗДАЛИ
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) { //получаем из запроса значение id
        Employee employee=employeeService.getEmployee(id);
        model.addAttribute("employee", employee); //теперь вью будет отбражаться с заполненными формами
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) { //получаем из запроса значение id
employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
