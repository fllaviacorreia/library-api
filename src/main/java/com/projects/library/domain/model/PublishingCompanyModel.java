package com.projects.library.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublishingCompanyModel {
	
	private Long id;
	private String name;
	private String city;
	private String state;
	private String country;
}