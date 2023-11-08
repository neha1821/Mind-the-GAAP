package com.mindgate.main.domain;

public class Customer {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private int zip;
	private long phone;
	private long cell;
	private String email;
	private int customerId;
	private String customerStatus;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String username, String password, String addressLine1,
			String addressLine2, String addressLine3, String city, String state, int zip, long phone, long cell,
			String email, int customerId, String customerStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.cell = cell;
		this.email = email;
		this.customerId = customerId;
		this.customerStatus = customerStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", cell="
				+ cell + ", email=" + email + ", customerId=" + customerId + ", customerStatus=" + customerStatus + "]";
	}
	
	
	
}
