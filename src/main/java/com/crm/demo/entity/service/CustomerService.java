package com.crm.demo.entity.service;

import java.util.List;

import com.crm.demo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void save(Customer customer);
	public void deleteById(int id);
}
