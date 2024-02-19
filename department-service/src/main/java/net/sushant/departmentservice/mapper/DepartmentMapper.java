package net.sushant.departmentservice.mapper;

import net.sushant.departmentservice.dto.DepartmentDto;
import net.sushant.departmentservice.entity.Department;

public class DepartmentMapper {

    public DepartmentDto mapToDeparmentDto(Department department){

        return new DepartmentDto();
    }
}