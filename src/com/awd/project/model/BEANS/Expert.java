package com.awd.project.model.BEANS;

public class Expert {
	
	private int id;
	private String first_name;
	private String last_name;
	private String qualifications;
	private String expertise;
	private String email;
	
	
	public Expert(int id, String first_name, String last_name, String qualifications, String expertise, String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.qualifications = qualifications;
		this.expertise = expertise;
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


	public String getQualifications() {
		return qualifications;
	}


	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Expert [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", qualifications="
				+ qualifications + ", expertise=" + expertise + ", email=" + email + "]";
	}

	
	
	
}
