package com.example.Employee.Service.Repository;

import com.example.Employee.Service.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);

    Page<Employee> findAllByNameContainingIgnoreCase(String searchText, Pageable pageable);

}
