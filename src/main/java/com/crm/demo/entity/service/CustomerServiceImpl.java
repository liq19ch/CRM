package com.crm.demo.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.demo.dao.CustomerDAO;
import com.crm.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
	
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		customerDAO.deleteById(id);

	}

}
