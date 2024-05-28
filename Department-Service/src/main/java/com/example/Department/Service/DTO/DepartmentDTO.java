package com.example.Department.Service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDTO {

    private Long Id;
    private String departmentName;
    private  String description;
    private String code;
}
