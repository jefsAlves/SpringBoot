package com.example.demo.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;	
	private String phone;
	private String passaword;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> status = new ArrayList<>();

	public User() {
	}

	public User(Long id, String name, String email, String phone, String passaword) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passaword = passaword;
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

	public String getPassaword() {
		return passaword;
	}

	public void setPassaword(String passaword) {
		this.passaword = passaword;
	}

	public List<Order> getStatus() {
		return status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Id: "
				+ id
				+ ", Name: "
				+ name
				+ ", Email: "
				+ email
				+ ", Phone: "
				+ phone
				+ ", Passaword: "
				+ passaword;
	}
}
