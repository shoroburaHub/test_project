package ua.service;

import ua.entity.Department;

import java.util.List;

/**
 * Created by admin on 7/4/2017.
 */
public interface DepartmentService {

    void save(Department department);

    List<Department> findAll();

    void delete(int id);

}
