package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String addressLine1 = rs.getString("address_line_1");
		String addressLine2 = rs.getString("address_line_2");
		String addressLine3 = rs.getString("address_line_3");
		String city = rs.getString("city");
		String state = rs.getString("state");
		int zip = rs.getInt("Zip");
		long phone = rs.getLong("phone");
		long cell = rs.getLong("cell");
		String email = rs.getString("email");
		int customerId = rs.getInt("customer_id");
		String customerStatus = rs.getString("customer_status");
		 byte[] fileDetails =rs.getBytes("file_details");
		
		
		Customer customer = new Customer(firstName, lastName, username, password, addressLine1, addressLine2, addressLine3, city, state, zip, phone, cell, email, customerId, customerStatus,fileDetails);
		return customer;
	}
}
