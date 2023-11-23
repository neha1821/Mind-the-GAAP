package com.mindgate.main.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mindgate.main.domain.Customer;
import com.mindgate.main.service.CustomerServiceInterface;

@RestController
@RequestMapping("customerapi")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerServiceInterface;
	
	
	
	
	@RequestMapping(value = "upload/{customerId}", method = RequestMethod.PUT)
	public boolean uploadFile(@PathVariable int customerId ,@RequestParam("file") MultipartFile file) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		try {
			customer.setFileDetails(file.getBytes());
		} catch (IOException e) {
			System.out.println("Exception while file upload");
		}
		return customerServiceInterface.updateFileOnly(customer);
	}

	@RequestMapping(value = "/files/{customerId}")
	public ResponseEntity<byte[]> getFile(@PathVariable int customerId) {
		Customer customer = customerServiceInterface.getCustomerByCustomerId(customerId);
		return ResponseEntity.ok()
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + customer.getFirstName()+"'s  File  " + "\"")
				.body(customer.getFileDetails());
	}

	// http://localhost:8081/customerCRUDapi/customers
	@RequestMapping(value = "customers" , method = RequestMethod.POST )
	public boolean addNewCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
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
	
//	@RequestMapping(value = "customersAdd" , method = RequestMethod.POST)
//	public Customer getCustomerIdByUserName(@RequestBody Customer customer) {
//		System.out.println(customer);
//		return customerServiceInterface.addCustomer(customer);
//	}
	
	@RequestMapping(value = "customers/username" , method = RequestMethod.POST )
	public Customer getCustomerByCustomerUsername(@RequestBody Customer customer) {
		return customerServiceInterface.getCustomerByCustomerUsername(customer);
	}
	
	@RequestMapping(value = "customers/customerStatus" , method = RequestMethod.GET )
	public List<Customer> getCustomerByCustomerStatus() {
		return customerServiceInterface.getCustomerByCustomerStatus();
	} 
	
	@RequestMapping(value = "customerstatus/{customerId}" , method = RequestMethod.GET)
	public boolean changeCustomerStatus(@PathVariable int customerId) {
		return customerServiceInterface.changeCustomerStatus(customerId);
	}
	
}
