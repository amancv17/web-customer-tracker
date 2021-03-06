package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {

		Session currentsession = sessionFactory.getCurrentSession();

		currentsession.saveOrUpdate(thecustomer);

	}

	@Override
	public Customer getCustomer(int theCustomerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theCustomerId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theCustomerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from customer where id = customerId");
		query.setParameter("customerId", theCustomerId);
		query.executeUpdate();
	}
}
