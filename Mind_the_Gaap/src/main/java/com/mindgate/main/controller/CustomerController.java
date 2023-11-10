package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Customer;
import com.mindgate.main.service.CustomerServiceInterface;

@RestController
@RequestMapping("customerapi")
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerServiceInterface;

	// http://localhost:8081/customerCRUDapi/customers
	@RequestMapping(value = "customers" , method = RequestMethod.POST )
	public boolean addNewCustomer(@RequestBody Customer customer) {
		return customerServiceInterface.addNewCustomer(customer);
	}

	@RequestMapping(value = "customers" , method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServiceInterface.updateCustomer(customer);
	}

	@RequestMapping(value = "customers/{customerId}" , method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable int customerId) {
		return customerServiceInterface.deleteCustomer(customerId);
	}

	@RequestMapping(value = "customers/{customerId}" , method = RequestMethod.GET )
	public Customer getCustomerByCustomerId(@PathVariable int customerId) {
		return customerServiceInterface.getCustomerByCustomerId(customerId);
	}

	@RequestMapping(value = "customers" , method = RequestMethod.GET )
	public List<Customer> getAllCustomers() {
		System.out.println("All Customers");
		return customerServiceInterface.getAllCustomers();
	}
	
}
