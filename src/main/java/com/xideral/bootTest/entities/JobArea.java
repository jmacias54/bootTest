package com.xideral.bootTest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cat_job_area", schema = "sch_test")
public class JobArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "joa_id")
	private Long id;

	@Column(name = "joa_name")
	private String name;

	@Column(name = "joa_abbreviation")
	private String abbreviation;

	// Constructor, getters, and setters

	public JobArea() {
	}

	// Constructor with fields

	public JobArea(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
