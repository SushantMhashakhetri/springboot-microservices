package com.sushant.organizationservice.service;

import org.springframework.http.ResponseEntity;

import com.sushant.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

   OrganizationDto saveOrganization(OrganizationDto organizationDto);
   OrganizationDto getOrganizationByCode(String organizationCode);
    
}