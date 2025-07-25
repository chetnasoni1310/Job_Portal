package com.jobportal.jobportal.model;

import jakarta.persistence.*;


@Entity
@Table(name ="students")

public class Student {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String qualifiaction;
	private String resumeURL;


    public Student() {
    }


    public Student(Long id, String name, String email, String phone, String qualifiaction, String resumeURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualifiaction = qualifiaction;
        this.resumeURL = resumeURL;
    }


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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getQualifiaction() {
        return qualifiaction;
    }


    public void setQualifiaction(String qualifiaction) {
        this.qualifiaction = qualifiaction;
    }


    public String getResumeURL() {
        return resumeURL;
    }


    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    
}
