package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// JPQL
	@Query("select e from Employee e where e.address =:add")
	List<Employee> findEmpByAddress(@Param("add") String add);

	@Query(value = "select * from employee where address =:add", nativeQuery = true)
	List<Employee> getEmpByAddress(@Param("add") String add);
}
