package com.example.Employee.Service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

    private  Long Id;
    private String name;
    private  String address;
    private  String email;
    private String departmentCode;
}
