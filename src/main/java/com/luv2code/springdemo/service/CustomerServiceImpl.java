package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer thecustomer) {
		
		customerDAO.saveCustomer(thecustomer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int theCustomerId) {
		
		return customerDAO.getCustomer(theCustomerId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int theCustomerId) {
		
		customerDAO.deleteCustomer(theCustomerId);
	}

}
