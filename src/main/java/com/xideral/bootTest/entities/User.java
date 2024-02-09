package com.xideral.bootTest.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_user", schema = "sch_test")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Integer userId;

	@Column(name = "emp_id")
	private Integer employeeId;

	@Column(name = "usr_email")
	private String userEmail;

	@Column(name = "usr_name")
	private String userName;

	@Column(name = "usr_password")
	private String userPassword;

	@Column(name = "usr_status")
	private boolean userStatus;
}
