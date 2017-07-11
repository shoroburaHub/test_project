package ua.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.dao.EmployeeDao;
import ua.entity.Employee;
import ua.service.EmployeeService;

import java.util.List;

/**
 * Created by admin on 7/4/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeDao.findAll(pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable, String search) {
        return employeeDao.findAll(search, pageable);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }

}
