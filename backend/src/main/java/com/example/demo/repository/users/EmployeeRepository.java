package com.example.demo.repository.users;

import com.example.demo.model.users.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("select e from Employee e left join fetch e.engagementList el where e.id =?1")
    Employee getEmployeeWithEngagements(int id);
}
