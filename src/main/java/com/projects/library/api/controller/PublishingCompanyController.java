package com.projects.library.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.library.domain.model.PublishingCompanyModel;

@RestController
public class PublishingCompanyController {
	
	@GetMapping("/publishing-companies")
	public List<PublishingCompanyModel> getPublishingCompanies(){
		
		PublishingCompanyModel pcModel1 = new PublishingCompanyModel();
		pcModel1.setId(1L);
		pcModel1.setName("Companhia das Letras");
		pcModel1.setCity("São Paulo");
		pcModel1.setState("SP");
		pcModel1.setCountry("Brasil");
		
		PublishingCompanyModel pcModel2 = new PublishingCompanyModel();
		pcModel2.setId(2L);
		pcModel2.setName("Intríseca");
		pcModel2.setCity("Rio de Janeiro");
		pcModel2.setState("RJ");
		pcModel2.setCountry("Brasil");
		 
		return Arrays.asList(pcModel1, pcModel2);
	}
}
