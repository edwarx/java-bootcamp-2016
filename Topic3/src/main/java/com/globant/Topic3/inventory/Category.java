package com.globant.Topic3.inventory;

public class Category {

	private int id;
	private String name;
	private String description;

	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Category c) {
		if (this.id == c.getId()) {
			return true;
		}
		return false;

	}

}
