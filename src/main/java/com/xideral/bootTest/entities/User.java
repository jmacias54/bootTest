package com.xideral.bootTest.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cat_user", schema = "sch_test")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Integer userId;

	@Column(name = "emp_id",unique = true)
	private Integer employeeId;

	@Column(name = "usr_email",unique = true)
	private String userEmail;

	@Column(name = "usr_name", unique = true)
	private String userName;

	@Column(name = "usr_password")
	private String userPassword;

	@Column(name = "usr_status")
	private boolean userStatus;
}
