package com.spring11.model;

import java.io.Serializable;


public class ModelPerson implements Serializable {
	private String id;
	private String name;
	private String email;
    private String country;

    
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", country=" + country + ", email=" + email + "]";
	}

}
