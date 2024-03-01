package com.example.CrudApplication.DAO;

import com.example.CrudApplication.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
