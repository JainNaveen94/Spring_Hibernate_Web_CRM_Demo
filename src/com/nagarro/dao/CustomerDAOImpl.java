package com.nagarro.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Inject The Session Factory Dependency
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get The Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// create The Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute The Query and get The Result
		List<Customer> customers = null;
		try {
			customers = theQuery.getResultList();
		} catch (NoResultException exception) {
			return null;
		}

		// return the Result
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {

		// get The Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save Customer Data To DataBase
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		// Get The CurrentSession From The Session Factory
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrive The Result From The DB Through CurrentSession Object.
		// return To The Customer Service Object
		return currentSession.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		
		// Get The CurrentSession From The SessionFactory
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Get The Customer From The Id 
		Customer customer = getCustomer(id);
		
		// Delete The Customer From The Data Base
		currentSession.delete(customer);
	}

}
