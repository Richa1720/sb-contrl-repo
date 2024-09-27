package com.spring_boot_controller_to_repo.sb_contrl_repo.repository;

import com.spring_boot_controller_to_repo.sb_contrl_repo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
}


