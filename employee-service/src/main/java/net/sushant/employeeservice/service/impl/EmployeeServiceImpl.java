package net.sushant.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.sushant.employeeservice.dto.APIResponseDto;
import net.sushant.employeeservice.dto.DepartmentDto;
import net.sushant.employeeservice.dto.EmployeeDto;
import net.sushant.employeeservice.dto.OrganizationDto;
import net.sushant.employeeservice.entity.Employee;
import net.sushant.employeeservice.mapper.EmployeeMapper;
import net.sushant.employeeservice.repository.EmployeeRepository;
import net.sushant.employeeservice.service.APIClient;
import net.sushant.employeeservice.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

//     private RestTemplate restTemplate;
   private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

//     @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override 
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("Inside getEmployeeById");
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

       DepartmentDto departmentDto = webClient.get()
               .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
               .retrieve()
               .bodyToMono(DepartmentDto.class)
               .block();

        // DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get()
        .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
        .retrieve()
        .bodyToMono(OrganizationDto.class)
        .block();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("Inside getDefaultDepartment");
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

       DepartmentDto departmentDto = new DepartmentDto();
       departmentDto.setDepartmentName("R&D Department");
       departmentDto.setDepartmentDescription("Angular");
       departmentDto.setDepartmentCode("SUSHANT");

        // DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        // EmployeeDto employeeDto = new EmployeeDto(
        //         employee.getId(),
        //         employee.getFirstName(),
        //         employee.getLastName(),
        //         employee.getEmail(),
        //         employee.getDepartmentCode()
        // );
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
