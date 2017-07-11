package ua.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dao.DepartmentDao;
import ua.dao.EmployeeDao;
import ua.entity.Department;
import ua.entity.Employee;
import ua.service.DepartmentService;

import java.util.List;

/**
 * Created by admin on 7/4/2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void delete(int id) {
        departmentDao.delete(id);
    }
}
