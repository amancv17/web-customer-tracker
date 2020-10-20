package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@GetMapping("/list")
	public String listCustomer(Model themodel) {

		List<Customer> theCustomer = customerservice.getCustomers();

		themodel.addAttribute("customer", theCustomer);

		return "list-customer";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer thecustomer = new Customer();

		theModel.addAttribute("customer", thecustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {

		customerservice.saveCustomer(thecustomer);
		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId") int theCustomerId, Model theModel) {

	    Customer customer = customerservice.getCustomers(theCustomerId);

	    theModel.addAttribute("customer", customer);

		return "customer-form";

	}

}
