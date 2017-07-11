package ua.dto;

import ua.dao.DepartmentDao;

/**
 * Created by admin on 7/4/2017.
 */
public class EmployeeDto {

    private int id;
    private String name;
    private boolean active;
    private DepartmentDto department;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, boolean active, DepartmentDto department) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", department=" + department +
                '}';
    }
}
