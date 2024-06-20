package com.awd.project.model.BEANS;

public class Undergraduate {
	
	private int id;
	private String first_name;
	private String last_name;
	private String expertise;
	private String experience;
	private String email;
	
	public Undergraduate(int id, String first_name, String last_name, String expertise, String experience,
			String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.expertise = expertise;
		this.experience = experience;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Undergraduate [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", expertise="
				+ expertise + ", experience=" + experience + ", email=" + email + "]";
	}
	
	
	

}
