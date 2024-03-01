package com.example.CrudApplication.Controller;

import com.example.CrudApplication.Entity.Employee;
import com.example.CrudApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String list(Model themodel){
        //get list of employees from the DB
        List<Employee> employees = employeeService.findAll();
        // add the list of employees to the model
        themodel.addAttribute("employees", employees);
        return "employeeList";

    }
    @GetMapping("/ShowFormForAdd")
    public String showFormForAdd(Model themodel){
        Employee employee = new Employee();
        themodel.addAttribute("employees", employee);
        return "employeeForm";
    }
    @GetMapping("showFormForUpdate")
    public String update(@RequestParam ("employeeId") int theId, Model themodel){
        Employee employee = employeeService.findById(theId);
        themodel.addAttribute("employees", employee);
        return "EmployeeUpdate";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employees") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam ("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
