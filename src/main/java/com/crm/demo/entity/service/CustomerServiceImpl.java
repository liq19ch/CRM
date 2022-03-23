package com.crm.demo.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.demo.dao.CustomerRepository;
import com.crm.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int id) {
		Optional<Customer> res = customerRepository.findById(id);
		Customer customer = null;
		if (res.isPresent()) {
			customer = res.get();
		} else {
			throw new RuntimeException("Customer is not found with id: " + id);
		}
		return customer;
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}

}
