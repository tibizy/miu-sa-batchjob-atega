package com.miusaatega.batchjob.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	private int id;
	private String firstname;
	private String lastname;
	private float gpa;
	private Date dob;
}