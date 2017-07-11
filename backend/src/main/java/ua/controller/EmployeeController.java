package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.dto.DtoUtilMapper;
import ua.dto.EmployeeDto;
import ua.entity.Employee;
import ua.service.EmployeeService;

/**
 * Created by admin on 7/4/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(params = {"page", "size"})
    public Page<EmployeeDto> getAll(Pageable pageable) {
        return employeeService.findAll(pageable).map(DtoUtilMapper::employeeToEmployeeDto);
    }

    @GetMapping(params = {"page", "size", "search"})
    public Page<EmployeeDto> getAll(Pageable pageable, @RequestParam String search) {
        return employeeService.findAll(pageable, search).map(DtoUtilMapper::employeeToEmployeeDto);
    }

    @PostMapping
    public HttpStatus save(@RequestBody EmployeeDto  employeeDto){
        employeeService.save(DtoUtilMapper.employeeDtoToEmployee(employeeDto));
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(DtoUtilMapper.employeeDtoToEmployee(employeeDto));
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable int id) {
        employeeService.delete(id);
        return HttpStatus.OK;
    }


}
