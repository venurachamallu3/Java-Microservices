package com.example.Employee.Service.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage  {

    private LocalDateTime localDateTime;
    private String message;
    private  String details;

}
