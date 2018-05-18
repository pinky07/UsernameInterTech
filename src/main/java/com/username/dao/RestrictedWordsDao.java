package com.username.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.username.model.RestrictedWords;


@Repository
@Transactional
public interface RestrictedWordsDao extends JpaRepository <RestrictedWords, Long>{
	
	 
	 public void saveOrUpdate(RestrictedWords res);
	 
	 public RestrictedWords findCustomerById(int id);
	 
	 public void deleteCustomer(int id);
	 
	 public List<RestrictedWords>findAll();
}
