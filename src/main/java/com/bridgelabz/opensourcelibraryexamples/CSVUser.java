package com.bridgelabz.opensourcelibraryexamples;

import com.opencsv.bean.CsvBindByName;

public class CSVUser 
{

	
	@CsvBindByName
	private String name;
	
	@CsvBindByName(column="email",required=true)
	private String email;
	
	@CsvBindByName(column="phone")
	private String phoneNumber;
	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@CsvBindByName
	private String country;
	
	@Override
	public String toString()
	{
		return "CSVUser{"+
				"name='"+name+'\''+
				",email='"+email+'\''+
				",phoneNumber='"+phoneNumber+'\''+
				",country='"+country+'\''+
				'}';
	}
}
