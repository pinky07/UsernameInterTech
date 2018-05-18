package com.username.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.username.model.UserNameSuggestion;

@Repository
public class UserNameSuggestionDaoImpl implements UserNameSuggestionDao {

 @Autowired
 private SessionFactory sessionFactory;

 protected Session getSession(){
  return sessionFactory.getCurrentSession();
 }
 
 @SuppressWarnings("unchecked")
 public List listAllCustomers() {
  Criteria criteria = getSession().createCriteria(UserNameSuggestion.class);
  return (List) criteria.list();
 }

 public void saveOrUpdate(UserNameSuggestion userNameSuggestion) {
  getSession().saveOrUpdate(userNameSuggestion);
 }

 public UserNameSuggestion findCustomerById(int id) {
  UserNameSuggestion userNameSuggestion = (UserNameSuggestion) getSession().get(UserNameSuggestion.class, id);
  return userNameSuggestion;
 }

 public void deleteCustomer(int id) {
  UserNameSuggestion userNameSuggestion = (UserNameSuggestion) getSession().get(UserNameSuggestion.class, id);
  getSession().delete(userNameSuggestion);
 }

@Override
public List<UserNameSuggestion> findByUserName(String username) {
	Criteria criteria = getSession().createCriteria(UserNameSuggestion.class);
	Query q = getSession().createQuery("SELECT u.username  FROM usernamesuggestion u WHERE u.username = :username");
	q.setParameter("username", username);
	List<UserNameSuggestion> list = q.list();
//	 Criteria criteria =getSession().createCriteria(UserNameSuggestion.class);// TODO Auto-generated method stub
//	 criteria.addOrder(Order.asc("userNameSuggestion"));
	return list;
}
}