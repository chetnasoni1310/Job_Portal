package com.jobportal.jobportal.dto;

import lombok.Data;

@Data
public class StudentDTO {
    
	public Long id;
	public String name;
	public String email;
	public String phone;
	public String qualification;
	public String resumeleURL;

    
    public StudentDTO(Long id, String name, String email, String phone, String qualification, String resumeleURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.resumeleURL = resumeleURL;
    }

}
