package com.crm.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
