package com.xideral.bootTest.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "cat_job_area_user", schema = "sch_test")
public class JobAreaUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "joau_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "joa_id", nullable = false)
	private JobArea catJobArea;

	@ManyToOne
	@JoinColumn(name = "usr_id", nullable = false)
	private User catUser;

	// Constructor, getters, and setters

	public JobAreaUser() {
	}

	// Constructor with fields

	public JobAreaUser(JobArea catJobArea, User catUser) {
		this.catJobArea = catJobArea;
		this.catUser = catUser;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobArea getCatJobArea() {
		return catJobArea;
	}

	public void setCatJobArea(JobArea catJobArea) {
		this.catJobArea = catJobArea;
	}

	public User getCatUser() {
		return catUser;
	}

	public void setCatUser(User catUser) {
		this.catUser = catUser;
	}
}
