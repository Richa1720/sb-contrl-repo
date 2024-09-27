package com.spring_boot_controller_to_repo.sb_contrl_repo.controller;

import com.spring_boot_controller_to_repo.sb_contrl_repo.entity.Employee;
import com.spring_boot_controller_to_repo.sb_contrl_repo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    //constructor
    /*public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository=employeeRepository;
    }*/

    //create
    @PostMapping("/create/api")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        Employee createEmp=employeeRepository.save(employee);
        return new ResponseEntity<>(createEmp, HttpStatus.CREATED);
    }

    //getById
    @GetMapping("/get_emp_id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Optional<Employee> employee=employeeRepository.findById(id);
        return new ResponseEntity<>(employee.get(),HttpStatus.OK);
    }

    //getAll
    @GetMapping("/get_all_emp")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees=employeeRepository.findAll();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    //update
    @PutMapping("/update_emp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
    {
        employee.setEmpId(id);
        Employee existingEmployee=employeeRepository.findById(employee.getEmpId()).get();

        existingEmployee.setEmpId(employee.getEmpId()).
                setEmpName(employee.getEmpName()).
                setPhnNo(employee.getPhnNo()).
                setDoj(employee.getDoj()).
                setDob(employee.getDob()).
                setDol(employee.getDol()).
                setProDate(employee.getProDate());
        Employee updatedEmployee=employeeRepository.save(existingEmployee);

        return new ResponseEntity<>(updatedEmployee,HttpStatus.ACCEPTED);
    }

    //delete
    @DeleteMapping("/del_emp")
    public ResponseEntity<String> deleteEmployee(@RequestParam long id)
    {
        employeeRepository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted employee...",HttpStatus.OK);
    }


}
