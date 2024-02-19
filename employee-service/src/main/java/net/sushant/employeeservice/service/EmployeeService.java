package net.sushant.employeeservice.service;

import net.sushant.employeeservice.dto.APIResponseDto;
import net.sushant.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
