package com.mindgate.main.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Customer;
import com.mindgate.main.repository.CustomerRepositoryInterface;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepositoryInterface customerRepositoryInterface;
	
	public CustomerService() {
		System.out.println("Service");
	}
	
	@Override
	public boolean addNewCustomer(Customer customer) {
		return customerRepositoryInterface.addNewCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepositoryInterface.updateCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerRepositoryInterface.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		return customerRepositoryInterface.getCustomerByCustomerId(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepositoryInterface.getAllCustomers();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepositoryInterface.addCustomer(customer);
	}

	@Override
	public Customer getCustomerByCustomerUsername(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepositoryInterface.getCustomerByCustomerUsername(customer);
	}

	@Override
	public List<Customer> getCustomerByCustomerStatus() {
		// TODO Auto-generated method stub
		return customerRepositoryInterface.getCustomerByCustomerStatus();
	}

	@Override
	public boolean changeCustomerStatus(int customerId) {
		return customerRepositoryInterface.changeCustomerStatus(customerId);
	}

	@Override
	public Customer getFileByFileId(int customerId) {
		// TODO Auto-generated method stub
		return customerRepositoryInterface.getFileByFileId(customerId);
	}

	@Override
	public boolean updateFileOnly(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepositoryInterface.updateFileOnly(customer);
	}

//	@Override
//	public Stream<Customer> getAllFiles() {
//		// TODO Auto-generated method stub
//		return customerRepositoryInterface.getAllFiles();
//	}

}
