package com.crm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.demo.entity.Customer;
import com.crm.demo.entity.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String listAll(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "customers/list-customers";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customers/list";
	}

	@GetMapping("/addForm")
	public String addForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customers/customer-form";
	}

	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customers/customer-form";
	}

	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
	
		customerService.deleteById(id);
		return "redirect:/customers/list";
	}

}
