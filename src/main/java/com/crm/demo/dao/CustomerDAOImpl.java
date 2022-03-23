package com.crm.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
	@Transactional
	public List<Customer> getCustomers() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
