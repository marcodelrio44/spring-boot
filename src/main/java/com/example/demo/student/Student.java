package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize=1
			)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_sequence")
	private long id;
	private String email;
	private String firstName;
	private String lastName;
	@Transient
	private Integer age;
	private LocalDate dob;
	
	public Student() {
		
	}
	
	public Student(String email, String firstName, String lastName, LocalDate dob) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public Student(long id, String email, String firstName, String lastName, LocalDate dob) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", dob=" + dob + "]";
	}
	
	
	
}
