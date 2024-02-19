package com.sushant.organizationservice.serviceImpl;

import org.springframework.stereotype.Service;

import com.sushant.organizationservice.dto.OrganizationDto;
import com.sushant.organizationservice.mapper.OrganizationMapper;
import com.sushant.organizationservice.repo.OrganizationRepo;
import com.sushant.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepo organizationRepo;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        // TODO Auto-generated method stub
     return OrganizationMapper.mapToOrganizationDto(this.organizationRepo.save(OrganizationMapper.mapOrganization(organizationDto)));
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        // TODO Auto-generated method stub
        return OrganizationMapper.mapToOrganizationDto(this.organizationRepo.findByOrganizationCode(organizationCode));
    }
    
}