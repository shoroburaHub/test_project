package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.dto.DepartmentDto;
import ua.dto.DtoUtilMapper;
import ua.entity.Department;
import ua.service.DepartmentService;

import java.util.List;

/**
 * Created by admin on 7/7/2017.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getAll(){
        return DtoUtilMapper.departmentsToDepartmentsDtos(departmentService.findAll());
    }
    @PostMapping
    public HttpStatus save(@RequestBody DepartmentDto departmentDto){
        departmentService.save(DtoUtilMapper.departmentDtoToDepartment(departmentDto));
        return HttpStatus.OK;
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable int id) {
        departmentService.delete(id);
        return HttpStatus.OK;
    }

}
