package com.example.Employee.Service.Controller;


import com.example.Employee.Service.DTO.DepartmentDTO;
import com.example.Employee.Service.DTO.EmpDep;
import com.example.Employee.Service.DTO.EmployeeDTO;
import com.example.Employee.Service.Entity.Employee;
import com.example.Employee.Service.Repository.EmployeeRepository;
import com.example.Employee.Service.Service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

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

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String > deleteEmployee(@PathVariable("id") Long Id){
        return new ResponseEntity<>(employeeService.deleteEmployeeByID(Id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee employee,
                                                      @PathVariable("id") Long Id){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(Id,employee);
        return  new ResponseEntity<>(employeeDTO,HttpStatus.ACCEPTED);

    }


    @GetMapping("filter/emp")
    public Page<Employee> fetchEmployees(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size,
                                         @RequestParam(required = false) String searchText) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        if (!StringUtils.hasText(searchText)) {
            return employeeRepository.findAll(pageable);
        } else {
            return  employeeRepository.findAllByNameContainingIgnoreCase(searchText, pageable);
        }
    }

}
