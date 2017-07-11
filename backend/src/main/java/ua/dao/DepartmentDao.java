package ua.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entity.Department;

/**
 * Created by admin on 7/4/2017.
 */
public interface DepartmentDao extends JpaRepository<Department, Integer> {


}
