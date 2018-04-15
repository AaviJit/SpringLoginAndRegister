package org.avijitbarua.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Member {
	@NotNull
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 4, max = 15)
	private String name;
	@Size(min = 4, max = 20)
	private String userName;
	@NotBlank
	private String mobile;
	@NotBlank
	private String address;
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

	public Member(int id, String name, String userName, String mobile, String address, String password) {

		this.id = id;
		this.name = name;
		this.userName = userName;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}

	public Member(String name, String userName, String mobile, String address, String password) {

		this.name = name;
		this.userName = userName;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}

	public Member() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", userName=" + userName + ", mobile=" + mobile + ", address="
				+ address + ", password=" + password + "]";
	}

}
