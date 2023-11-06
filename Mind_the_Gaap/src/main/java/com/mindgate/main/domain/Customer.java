package com.mindgate.main.domain;

public class Customer {

	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String address_line_1;
	private String address_line_2;
	private String address_line_3;
	private String city;
	private String state;
	private int zip;
	private long phone;
	private long cell;
	private String email;
	private int customer_id;
	private String customer_status;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String first_name, String last_name, String username, String password,
			String address_line_1, String address_line_2, String address_line_3, String city, String state, int zip,
			long phone, long cell, String email, int customer_id, String customer_status) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.address_line_3 = address_line_3;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.cell = cell;
		this.email = email;
		this.customer_id = customer_id;
		this.customer_status = customer_status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getAddress_line_3() {
		return address_line_3;
	}

	public void setAddress_line_3(String address_line_3) {
		this.address_line_3 = address_line_3;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getCell() {
		return cell;
	}

	public void setCell(long cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	@Override
	public String toString() {
		return "Customer_Details [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + ", address_line_1=" + address_line_1 + ", address_line_2=" + address_line_2
				+ ", address_line_3=" + address_line_3 + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", phone=" + phone + ", cell=" + cell + ", email=" + email + ", customer_id=" + customer_id
				+ ", customer_status=" + customer_status + "]";
	}
	
}
