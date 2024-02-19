package com.sushant.organizationservice.repo;
import com.sushant.organizationservice.entity.Organization;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization,Integer>{

    Organization findByOrganizationCode(String organizationCode);
    
}