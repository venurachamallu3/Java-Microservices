package com.example.Employee.Service.Service.Impl;

import com.example.Employee.Service.DTO.DepartmentDTO;
import com.example.Employee.Service.DTO.EmpDep;
import com.example.Employee.Service.DTO.EmployeeDTO;
import com.example.Employee.Service.Entity.Employee;
import com.example.Employee.Service.Exception.IDNotFoundException;
import com.example.Employee.Service.Repository.EmployeeRepository;
import com.example.Employee.Service.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AppClient appClient;
//    private RestTemplate restTemplate;
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee e = employeeRepository.save(employee);
        return  modelMapper.map(e, EmployeeDTO.class);

    }

    public EmployeeDTO fetchByID(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new IDNotFoundException("Employee is not found with this ID "+id));
        return  modelMapper.map(employee,EmployeeDTO.class);

    }

    public List<Employee> fetchAllEmployees(){
        List<Employee> emp = employeeRepository.findAll();
        return  emp;
//        emp.stream().map(modelMapper.map(emp,EmployeeDTO.class)).collect(Collectors.toSet());
    }

    public EmpDep getEmployeeDept(Long id )
    {
        Employee e = employeeRepository.findById(id).orElseThrow(()->new IDNotFoundException("Employee is not found with the ID is "+id));
        EmployeeDTO employee = modelMapper.map(e,EmployeeDTO.class);
        System.out.println("employee"+employee.getDepartmentCode());
//        ResponseEntity<DepartmentDTO> department = restTemplate.getForEntity("http://localhost:8080/api/department/show/"+employee.getDepartmentCode() , DepartmentDTO.class);


        DepartmentDTO dep =  appClient.getDepartmentByCode(employee.getDepartmentCode());

//        DepartmentDTO dep = department.getBody();

        EmpDep employeeDep = new EmpDep();
        employeeDep.setEmpId(employee.getId());
        employeeDep.setEname(employee.getName());
        employeeDep.setEaddress(employee.getAddress());
        employeeDep.setEemail(employee.getEmail());
        employeeDep.setDepId(dep.getId());
        employeeDep.setDepartmentName(dep.getDepartmentName());
        employeeDep.setDepdescription(dep.getDescription());
        employeeDep.setDepcode(dep.getCode());


        return employeeDep;
    }


    public String deleteEmployeeByID(Long Id){
        employeeRepository.deleteById(Id);
        return "Successfully Deleted......";
    }

    public EmployeeDTO updateEmployee(Long id, Employee employee) {
        Employee em = employeeRepository.findById(id).get();
        if(em!=null){
            em.setName(employee.getName());
            em.setAddress(employee.getAddress());
            em.setEmail(employee.getEmail());
            em.setDepartmentCode(employee.getDepartmentCode());
        employeeRepository.save(em);
        }
        return modelMapper.map(em,EmployeeDTO.class);
    }
}
