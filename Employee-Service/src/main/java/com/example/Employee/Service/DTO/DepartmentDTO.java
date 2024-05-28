package com.example.Employee.Service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentDTO {

    private  Long Id;
    private String departmentName;
    private  String description;
    private String code;
}
