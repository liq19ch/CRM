package com.crm.demo.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Customer> getCustomers() {

		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		Customer resCustomer = null;
		if (customer.isPresent()) {
			resCustomer = customer.get();
		} else {
			throw new RuntimeException("Customer is not found with id : " + id);
		}
		return resCustomer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}

}
