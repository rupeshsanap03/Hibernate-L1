package com.sample.CollectionMap;

public class Faculty {
	private int facultyid;
	private String name;
	private Address address;

	public Faculty() {
	}

	public Faculty(int facultyid, String name) {
		this.facultyid = facultyid;
		this.name = name;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
