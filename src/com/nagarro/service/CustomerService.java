package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
