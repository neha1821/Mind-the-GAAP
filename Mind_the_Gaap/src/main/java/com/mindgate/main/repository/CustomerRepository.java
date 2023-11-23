package com.mindgate.main.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Customer;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String INSERT_NEW_CUSTOMER = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,customer_id_sequence.nextVal,?,?)";
	private final static String UPDATE_EXISTING_CUSTOMER = "update customer_details set first_name = ?, last_name = ?, username = ?, password = ?, address_line_1 = ?, address_line_2 = ?, address_line_3 = ?, city = ?, state = ?, zip = ?, phone = ?, cell = ?, email = ?, customer_status = ? where customer_id = ?";
	private final static String DELETE_EXISTING_CUSTOMER = "delete from customer_details where customer_Id=?";
	private final static String SELECT_ALL_CUSTOMERS = "select * from customer_details";
	private final static String SELECT_ONE_CUSTOMER = " select * from customer_details where customer_Id=?";
	private final static String SELECT_ONE = " select * from customer_details where username=?";
	private final static String SELECT_CUSTOMER_BY_USERNAME = " select * from customer_details where username=?";
	private final static String SELECT_ALLCUSTOMER_BY_STATUS = "select * from customer_details  where customer_status !='ACTIVE' OR CUSTOMER_STATUS IS NULL";

	private final static String CHANGE_CUSTOMER_STATUS = "update customer_details set CUSTOMER_STATUS='ACTIVE' where customer_id=?";

	private final static String upload_file_only = "update customer_details set file_details=? where customer_id=?";
	
	
	
	@Override
	public boolean updateFileOnly(Customer customer) {
		Object[] parameters= {customer.getFileDetails(),customer.getCustomerId()};
		int rowCount = jdbcTemplate.update(upload_file_only, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addNewCustomer(Customer customer) {
		
		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerStatus(),customer.getFileDetails()};
        int rowCount = jdbcTemplate.update(INSERT_NEW_CUSTOMER, parameters);
        if (rowCount > 0)
            return true;
        else
            return false;
	}
	
	@Override
	public Customer insertUpdateCustomer(Customer customer) {
		
		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerStatus(),customer.getCustomerId() };

		
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_CUSTOMER, parameters);
		if (rowCount > 0) {
			return getCustomerByCustomerId(customer.getCustomerId());
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerStatus(),customer.getCustomerId() };

	
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_CUSTOMER, parameters);
		if (rowCount > 0) {
			return getCustomerByCustomerId(customer.getCustomerId());
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		int rowCount =  jdbcTemplate.update(DELETE_EXISTING_CUSTOMER, customerId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		CustomerRowMapper customerRowMapper = new CustomerRowMapper();
		 return jdbcTemplate.queryForObject(SELECT_ONE_CUSTOMER,customerRowMapper, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		CustomerRowMapper customerRowMapper = new CustomerRowMapper();
		return jdbcTemplate.query(SELECT_ALL_CUSTOMERS, customerRowMapper);
	}

//	@Override
//	public Customer addCustomer(Customer customer) {
//		Object[] parameters = { customer.getFirstName(),customer.getLastName(),customer.getUsername(),customer.getPassword(),customer.getAddressLine1(),customer.getAddressLine2(),customer.getAddressLine3(),customer.getCity(),customer.getState(),customer.getZip(),customer.getPhone(),customer.getCell(),customer.getEmail(),customer.getCustomerStatus()};
//		int rowCount = jdbcTemplate.update(INSERT_NEW_CUSTOMER, parameters);
//		if (rowCount > 0) {
//
//			CustomerRowMapper customerRowMapper = new CustomerRowMapper();
//			 return jdbcTemplate.queryForObject(SELECT_ONE,customerRowMapper, customer.getUsername());
//			
//			
//		}
//		return null;
//	}

	@Override
	public Customer getCustomerByCustomerUsername(Customer customer) {
		CustomerRowMapper customerRowMapper = new CustomerRowMapper();
		 return jdbcTemplate.queryForObject(SELECT_CUSTOMER_BY_USERNAME,customerRowMapper,customer.getUsername());
	}

	@Override
	public List<Customer> getCustomerByCustomerStatus() {
		CustomerRowMapper cusRowMapper = new CustomerRowMapper();
		return jdbcTemplate.query(SELECT_ALLCUSTOMER_BY_STATUS, cusRowMapper);
	}
	
	@Override
	public boolean changeCustomerStatus(int customerId) {
		int rowCount = jdbcTemplate.update(CHANGE_CUSTOMER_STATUS,customerId);
		if (rowCount > 0)
			return true;        
		else
			return false;
		
	}

	

	@Override
	public Customer getFileByFileId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Stream<Customer> getAllFiles() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
