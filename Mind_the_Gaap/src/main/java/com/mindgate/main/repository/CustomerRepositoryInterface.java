package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Customer;

public interface CustomerRepositoryInterface {

	public boolean addNewCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public Customer getCustomerByCustomerId(int customerId);
	public List<Customer> getAllCustomers();

}
