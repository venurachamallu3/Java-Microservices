package com.example.Department.Service.Service.Impl;

import com.example.Department.Service.DTO.DepartmentDTO;
import com.example.Department.Service.Entity.Department;
import com.example.Department.Service.Repository.DepartmentRepository;
import com.example.Department.Service.Service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO){
        Department department = modelMapper.map(departmentDTO,Department.class);
        return modelMapper.map(departmentRepository.save(department),DepartmentDTO.class);
    }

    public Department getDepartmentByCode(String code ){
        Department department = departmentRepository.findByCode(code);
        return department;
    }



}
