package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Customer;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String INSERT_NEW_CUSTOMER = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,customer_id_sequence.nextVal,?)";
	private final static String UPDATE_EXISTING_CUSTOMER = "update customer_details set first_name = ?, last_name = ?, username = ?, password = ?, address_line_1 = ?, address_line_2 = ?, address_line_3 = ?, city = ?, state = ?, zip = ?, phone = ?, cell = ?, email = ?, customer_status = ? where employee_id = ?";
	private final static String DELETE_EXISTING_CUSTOMER = "delete from customer_details where employee_Id=?";
	private final static String SELECT_ALL_CUSTOMERS = "select * from customer_details";
	private final static String SELECT_ONE_CUSTOMER = " select * from customer_details where employee_Id = ?";

	@Override
	public boolean addNewCustomer(Customer customer) {
		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerStatus()};
		int rowCount = jdbcTemplate.update(INSERT_NEW_CUSTOMER, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerId(),customer.getCustomerStatus() };
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_CUSTOMER, parameters);
		if (rowCount > 0) {
			return getCustomerByCustomerId(customer.getCustomerId());
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int customer_id) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_CUSTOMER, customer_id);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Customer getCustomerByCustomerId(int customer_id) {
		CustomerRowMapper customerRowMapper = new CustomerRowMapper();
		 return jdbcTemplate.queryForObject(SELECT_ONE_CUSTOMER,customerRowMapper, customer_id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		CustomerRowMapper customerRowMapper = new CustomerRowMapper();
		return jdbcTemplate.query(SELECT_ALL_CUSTOMERS, customerRowMapper);
	}

}
