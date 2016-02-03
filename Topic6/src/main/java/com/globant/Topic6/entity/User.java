package com.globant.Topic6.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@OneToMany (mappedBy = "user", cascade=CascadeType.ALL)
	private List<Address> address;

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "Name of the user", required = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "First name of the user", required = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "Last name of the user", required = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "Adresses of the user", required = true)
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public boolean equals(User u) {
		if (this.username.compareTo(u.getUsername()) == 0) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
