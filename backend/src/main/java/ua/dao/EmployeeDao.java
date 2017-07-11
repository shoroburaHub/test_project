package ua.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entity.Employee;

import java.util.List;

/**
 * Created by admin on 7/4/2017.
 */
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

    @Query(value = "select e from Employee e where e.name like ?1%")
    Page<Employee> findAll(String search, Pageable pageable);
}
