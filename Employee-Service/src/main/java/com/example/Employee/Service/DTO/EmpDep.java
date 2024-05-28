package com.example.Employee.Service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmpDep {
    private  Long EmpId;
    private String Ename;
    private  String Eaddress;
    private  String Eemail;
    private  Long DepId;
    private String departmentName;
    private  String Depdescription;
    private String Depcode;

}
