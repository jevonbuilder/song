package test;

import java.sql.Date;

public class eightmain {
	String fname;
	String lname;
	String address;
	String city;
	String state;
	String zip;
	String phone;
	String email;
	String begindate;
	String lastdate;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public void setter(){
		this.setFname("jiang");
		this.setLname("zhen");
		this.setCity("zz");
		this.setState("haut");
		this.setAddress("gaoxin");
		this.setEmail("123");
		this.setPhone("546");
		this.setZip("450000");
		this.setBegindate("2012-12-14");
		this.setLastdate("2013-01-25");
	}
	
}
