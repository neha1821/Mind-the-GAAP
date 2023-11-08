package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		String first_name = rs.getString("first_name");
		String last_name = rs.getString("last_name");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String address_line_1 = rs.getString("address_line_1");
		String address_line_2 = rs.getString("address_line_2");
		String address_line_3 = rs.getString("address_line_3");
		String city = rs.getString("city");
		String state = rs.getString("state");
		int zip = rs.getInt("Zip");
		long phone = rs.getLong("phone");
		long cell = rs.getLong("cell");
		String email = rs.getString("email");
		int customer_id = rs.getInt("customer_id");
		String customer_status = rs.getString("customer_status");
		
		Customer customer = new Customer(first_name, last_name, username, password, address_line_1, address_line_2, address_line_3, city, state, zip, phone, cell, email, customer_id, customer_status);
		return customer;
	}
}
