package com.example.Employee.Service.Service.Impl;

import com.example.Employee.Service.DTO.DepartmentDTO;
import com.example.Employee.Service.DTO.EmpDep;
import com.example.Employee.Service.DTO.EmployeeDTO;
import com.example.Employee.Service.Entity.Employee;
import com.example.Employee.Service.Repository.EmployeeRepository;
import com.example.Employee.Service.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee e = employeeRepository.save(employee);
        return  modelMapper.map(e, EmployeeDTO.class);

    }

    public EmployeeDTO fetchByID(Long id){
        Employee employee = employeeRepository.findById(id).get();
        return  modelMapper.map(employee,EmployeeDTO.class);

    }

    public EmpDep getEmployeeDept(Long id )
    {
        EmployeeDTO employee = modelMapper.map(employeeRepository.findById(id).get(),EmployeeDTO.class);
        System.out.println("employee"+employee.getDepartmentCode());
        ResponseEntity<DepartmentDTO> department = restTemplate.getForEntity("http://localhost:8080/api/department/show/"+employee.getDepartmentCode() , DepartmentDTO.class);

        DepartmentDTO dep = department.getBody();

        EmpDep employeeDep = new EmpDep();
        employeeDep.setDepId(employee.getId());
        employeeDep.setEname(employee.getName());
        employeeDep.setEaddress(employee.getAddress());
        employeeDep.setEemail(employee.getEmail());
        employeeDep.setDepId(dep.getId());
        employeeDep.setDepartmentName(dep.getDepartmentName());
        employeeDep.setDepdescription(dep.getDescription());
        employeeDep.setDepcode(dep.getCode());


        return employeeDep;
    }
}
