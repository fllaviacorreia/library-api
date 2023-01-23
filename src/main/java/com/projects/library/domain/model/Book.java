package com.projects.library.domain.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Book {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 200)
	private String title;
	
	@NotBlank
	@Column(name = "date_publication")
	private LocalDate datePublication;
	
	@NotBlank
	@Column(name = "number_copies")
	private Integer numberCopies;
	
	@NotBlank
	@OneToOne
	private PublishingCompany pCompany;
	
	@ManyToMany
	@JoinTable(
	  name = "book_has_category", 
	  joinColumns = @JoinColumn(name = "id_book"), 
	  inverseJoinColumns = @JoinColumn(name = "id_category"))
	Set<Category> categories;
	
	@ManyToMany
	@JoinTable(
	  name = "book_has_writer", 
	  joinColumns = @JoinColumn(name = "id_book"), 
	  inverseJoinColumns = @JoinColumn(name = "id_writer"))
	Set<Writer> writers;
}
