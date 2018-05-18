package com.username.service;

import java.util.List;

import com.username.model.UserNameSuggestion;
import com.username.vo.Result;

public interface UserNameSuggestionService {
 

 public void saveOrUpdate(UserNameSuggestion username);

public Result checkUsername(String username) throws Exception;
 
}