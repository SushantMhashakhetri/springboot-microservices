package com.sushant.organizationservice.mapper;

import com.sushant.organizationservice.dto.OrganizationDto;
import com.sushant.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {

        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreationDate());
        return organizationDto;
    }

    public static Organization mapOrganization(OrganizationDto organizationDto) {

        Organization organization = new Organization(
            organizationDto.getId(),
            organizationDto.getOrganizationName(),
            organizationDto.getOrganizationDescription(),
            organizationDto.getOrganizationCode(),
            organizationDto.getCreationDate());
        return organization;
    }

}