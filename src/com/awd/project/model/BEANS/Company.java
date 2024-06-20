package com.awd.project.model.BEANS;

public class Company {
	
	private int id;
	private String first_name;
	private String status;
	private String activities;
	private String profile;
	private String employers;
	private String email;
	
	public Company(int id, String first_name, String status, String activities, String profile, String employers,
			String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.status = status;
		this.activities = activities;
		this.profile = profile;
		this.employers = employers;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEmployers() {
		return employers;
	}

	public void setEmployers(String employers) {
		this.employers = employers;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", first_name=" + first_name + ", status=" + status + ", activities=" + activities
				+ ", profile=" + profile + ", employers=" + employers + ", email=" + email + "]";
	}

	
}
