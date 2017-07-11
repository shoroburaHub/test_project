package ua.dto;

import ua.entity.Department;
import ua.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 7/4/2017.
 */
public class DtoUtilMapper {

    public static List<EmployeeDto> employeesToEmployeeDtos(List<Employee> employees){

        return employees.stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getName(), employee.isActive(),
                        new DepartmentDto(employee.getDepartment().getId(), employee.getDepartment().getName())))
                .collect(Collectors.toList());
    }

    public static Employee employeeDtoToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.isActive(),
                new Department(employeeDto.getDepartment().getId(), employeeDto.getDepartment().getName()));
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(), employee.isActive(),
                new DepartmentDto(employee.getDepartment().getId(), employee.getDepartment().getName()));
    }

    public static List<DepartmentDto> departmentsToDepartmentsDtos(List<Department> departments){
        return departments.stream()
                .map(department -> new DepartmentDto(department.getId(), department.getName()))
                .collect(Collectors.toList());
    }

    public static Department departmentDtoToDepartment(DepartmentDto departmentDto){
        return new Department(departmentDto.getId(), departmentDto.getName());
    }

}
