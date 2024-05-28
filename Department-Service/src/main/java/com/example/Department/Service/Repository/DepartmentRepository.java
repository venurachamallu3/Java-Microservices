package com.example.Department.Service.Repository;


import com.example.Department.Service.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByCode(String code);

//    Department findByDepartmentCode(String code);
}
