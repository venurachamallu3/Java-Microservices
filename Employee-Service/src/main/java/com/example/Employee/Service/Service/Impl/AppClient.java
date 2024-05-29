package com.example.Employee.Service.Service.Impl;


import com.example.Employee.Service.DTO.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="DEPARTMENT-SERVICE")
public interface AppClient {
    @GetMapping("api/department/show/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("code") String code);

}
