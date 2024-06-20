package com.awd.project.model.BEANS;

public class Professional {

	private int id;
	private String first_name;
	private String last_name;
	private String profession;
	private String experience;
	private String project;
	private String email;
	
	public Professional(int id, String first_name, String last_name, String profession, String experience,
			String project, String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.profession = profession;
		this.experience = experience;
		this.project = project;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", profession="
				+ profession + ", experience=" + experience + ", project=" + project + ", email=" + email + "]";
	}

	
}
