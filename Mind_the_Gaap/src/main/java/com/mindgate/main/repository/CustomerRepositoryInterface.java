package com.mindgate.main.repository;

import java.util.List;
import java.util.stream.Stream;

import com.mindgate.main.domain.Customer;

public interface CustomerRepositoryInterface {

	public boolean addNewCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public Customer getCustomerByCustomerId(int customerId);
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	
	public Customer getCustomerByCustomerUsername(Customer customer);
	public List<Customer> getCustomerByCustomerStatus();
	boolean changeCustomerStatus(int customerId);
	
	public Customer insertUpdateCustomer(Customer customer);
	
	public boolean updateFileOnly(Customer customer);
	

	 Customer getFileByFileId(int customerId);

//	Stream<Customer> getAllFiles();


}
