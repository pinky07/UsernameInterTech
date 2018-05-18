package com.username.dao;

import java.util.List;

import com.username.model.UserNameSuggestion;

public interface UserNameSuggestionDao {
 
 public List listAllCustomers();
 
 public void saveOrUpdate(UserNameSuggestion userNameSuggestion);
 
 public UserNameSuggestion findCustomerById(int id);
 
 public void deleteCustomer(int id);
 public List<UserNameSuggestion>findByUserName(String username);
 
 
}