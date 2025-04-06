package com.wildteach.tutoringsystem.entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class studentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;
	
	private String last_name;
	private String first_name;
	private String middle_name;
	private Date birth_date;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String email;
	private String contact_number;
	private String address;
	private String username;
	private String course;
	private int year_level;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private String password;
	
	public studentEntity() {}
	public enum Role {
	    Tutee,
	    Tutor
	}
	public enum Gender {
	    Male,
	    Female,
	    Other
	}

	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear_level() {
		return year_level;
	}
	public void setYear_level(int year_level) {
		this.year_level = year_level;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
