package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Customer;
import com.mindgate.main.repository.CustomerRepositoryInterface;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepositoryInterface customerRepositoryInterface;
	
//	public CustomerService() {
//		System.out.println("Service");
//	}
	
	@Override
	public boolean addNewCustomer(Customer customer) {
		return customerRepositoryInterface.addNewCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepositoryInterface.updateCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customer_id) {
		return customerRepositoryInterface.deleteCustomer(customer_id);
	}

	@Override
	public Customer getCustomerByCustomerId(int customer_id) {
		return customerRepositoryInterface.getCustomerByCustomerId(customer_id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepositoryInterface.getAllCustomers();
	}

}