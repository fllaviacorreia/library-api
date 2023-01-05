package com.projects.library.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.library.domain.model.PublishingCompanyModel;

@Repository
public interface PublishingCompanyRepository extends JpaRepository<PublishingCompanyModel, Long>{

}

