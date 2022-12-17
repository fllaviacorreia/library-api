package com.projects.library.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.library.domain.model.PublishingCompanyModel;

@RestController
public class PublishingCompanyController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/publishing-companies")
	public List<PublishingCompanyModel> getPublishingCompanies(){
		return entityManager
				.createQuery("from publishing_companies", PublishingCompanyModel.class)
				.getResultList();
	}
}
