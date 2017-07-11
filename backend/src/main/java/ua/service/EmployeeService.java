package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Employee;

import java.util.List;

/**
 * Created by admin on 7/4/2017.
 */
public interface EmployeeService {

    void save(Employee employee);

    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAll(Pageable pageable, String search);

    void delete(int id);

}
