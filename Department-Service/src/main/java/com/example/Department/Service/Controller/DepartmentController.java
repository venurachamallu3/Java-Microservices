package com.example.Department.Service.Controller;


import com.example.Department.Service.DTO.DepartmentDTO;
import com.example.Department.Service.Entity.Department;
import com.example.Department.Service.Service.DepartmentService;
import com.example.Department.Service.Service.Impl.DepartmentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDTO), HttpStatus.CREATED);
    }


    @GetMapping("show/{code}")
    public  ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("code") String code){
        Department department = departmentService.getDepartmentByCode(code);
        return  new ResponseEntity<>(modelMapper.map(department,DepartmentDTO.class),HttpStatus.OK);
    }


}
