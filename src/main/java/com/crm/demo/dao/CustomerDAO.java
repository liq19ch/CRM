package com.crm.demo.dao;

import java.util.List;

import com.crm.demo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void save(Customer customer);
	public void deleteById(int id);

}
