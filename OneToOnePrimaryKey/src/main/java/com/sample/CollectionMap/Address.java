package com.sample.CollectionMap;

public class Address {
	private int addressid;
	private String street;
	private String city;
	private Faculty faculty;

	public Address() {
	}

	public Address(int addressid, String street, String city) {
		this.addressid = addressid;
		this.street = street;
		this.city = city;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}
