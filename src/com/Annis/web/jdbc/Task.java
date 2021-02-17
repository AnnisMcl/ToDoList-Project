package com.Annis.web.jdbc;

public class Task {
	
	private String id;
	private String descriptif;
	
	public Task(String id, String descriptif) {
		this.id = id;
		this.descriptif = descriptif;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	

}
