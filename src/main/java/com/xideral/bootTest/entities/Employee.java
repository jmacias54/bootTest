package com.xideral.bootTest.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cat_employee", schema = "sch_test", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"empName", "empFirstName", "empLastName"})
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer employeeId;

	@Column(name = "emp_name")
	private String employeeName;

	@Column(name = "emp_first_name")
	private String employeeFirstName;

	@Column(name = "emp_last_name")
	private String employeeLastName;

	@Column(name = "emp_birth_date")
	private Date employeeBirthDate;

}
