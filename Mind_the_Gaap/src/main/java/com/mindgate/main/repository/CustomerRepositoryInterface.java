package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Customer;

public interface CustomerRepositoryInterface {

	public boolean addNewCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public boolean deleteCustomer(int customer_id);
	public Customer getCustomerByCustomerId(int customer_id);
	public List<Customer> getAllCustomers();

}
