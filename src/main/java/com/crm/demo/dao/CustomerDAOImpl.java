package com.crm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> getCustomers() {
		
		Query query = entityManager.createQuery("from Customer");
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Customer dbCustomer = entityManager.merge(customer);
		customer.setId(dbCustomer.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
