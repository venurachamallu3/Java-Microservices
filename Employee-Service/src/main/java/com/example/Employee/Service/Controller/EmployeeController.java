package com.example.Employee.Service.Controller;


import com.example.Employee.Service.DTO.DepartmentDTO;
import com.example.Employee.Service.DTO.EmpDep;
import com.example.Employee.Service.DTO.EmployeeDTO;
import com.example.Employee.Service.Entity.Employee;
import com.example.Employee.Service.Service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(  employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("emp-show/{id}")
    public  ResponseEntity<EmployeeDTO> fetchByID(@PathVariable("id") Long id){
        return  new ResponseEntity<>(employeeService.fetchByID(id),HttpStatus.OK);
    }

    @GetMapping("show-all")
    public  ResponseEntity<List<Employee>> fetchAllEmployees(){
        return  new ResponseEntity<>(employeeService.fetchAllEmployees(),HttpStatus.OK);
    }




    @GetMapping("emp-dep/{id}")
    public ResponseEntity<EmpDep> getEmployeeDept(@PathVariable ("id") Long id ){
        EmpDep empdep = employeeService.getEmployeeDept(id);
        return  new ResponseEntity<>(empdep,HttpStatus.OK);
    }

}
