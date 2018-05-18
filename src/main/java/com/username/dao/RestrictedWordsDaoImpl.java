package com.username.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.username.model.RestrictedWords;
@Repository
public class RestrictedWordsDaoImpl implements RestrictedWordsDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	 @Autowired
	 private RestrictedWordsDao restrictedDao;

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }
	 
	 

	@Override
	public List<RestrictedWords> findAll(Sort arg0) {
		return restrictedDao.findAll();
	
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestrictedWords> save(Iterable<? extends RestrictedWords> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestrictedWords saveAndFlush(RestrictedWords arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RestrictedWords> findAll(Pageable arg0) {
		
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RestrictedWords arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends RestrictedWords> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RestrictedWords findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestrictedWords save(RestrictedWords arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteInBatch(Iterable<RestrictedWords> arg0) {
		// TODO Auto-generated method stub
		
	}



	


	@Override
	public void saveOrUpdate(RestrictedWords res) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public RestrictedWords findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<RestrictedWords> findAll() {
		 Criteria criteria = getSession().createCriteria(RestrictedWords.class);
		  return (List) criteria.list();
	}

}
