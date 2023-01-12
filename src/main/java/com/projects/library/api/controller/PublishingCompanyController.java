package com.projects.library.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projects.library.domain.model.PublishingCompanyModel;
import com.projects.library.domain.repository.PublishingCompanyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/publishing-companies")
public class PublishingCompanyController {

	private PublishingCompanyRepository pCompanyRepository;
	
	@GetMapping
	public List<PublishingCompanyModel> getPublishingCompanies(){
		return pCompanyRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PublishingCompanyModel> getPublishingCompany(@PathVariable Long id){
		return pCompanyRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PublishingCompanyModel createPublishingCompany(
			@Valid 
			@RequestBody PublishingCompanyModel pCompany) {
		
		return pCompanyRepository.save(pCompany);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PublishingCompanyModel> editPublishingCompany(
			@Valid
			@PathVariable Long id, 
			@RequestBody PublishingCompanyModel pCompany){
		
		if(!pCompanyRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		pCompany.setId(id);
		pCompany = pCompanyRepository.save(pCompany);
		
		return ResponseEntity.ok(pCompany);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PublishingCompanyModel> deletePublishingCompany(@PathVariable Long id){
		
		if(!pCompanyRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		pCompanyRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
}


