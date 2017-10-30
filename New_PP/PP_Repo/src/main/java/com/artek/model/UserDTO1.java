package com.artek.model;

import java.util.List;

public class UserDTO1 {
	
	private String fname;
	private String lname;
	private List<AddressDTO> add;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<AddressDTO> getAdd() {
		return add;
	}
	public void setAdd(List<AddressDTO> add) {
		this.add = add;
	}
	
}
