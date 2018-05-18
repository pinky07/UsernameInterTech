package com.username;


import org.springframework.beans.factory.annotation.Autowired;

import com.username.service.UserNameSuggestionService;
import com.username.service.UserNameSuggestionServiceImpl;
import com.username.vo.Result;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckUsernameApplicationTests  {
	@Autowired
	 UserNameSuggestionService userNameSuggestionService;
	
	@Autowired
	 UserNameSuggestionServiceImpl userNameSuggestionServiceImpl;

	
	private Result successResult;
    private Result failResult;
    
	 @Before
	public void setup(){
		 successResult = new Result();
		 successResult.setProcessResult(true);
	     successResult.setMessage("User name is valid");

	}
	 @Test
	 public void UserNameServiceSuccessTest() throws Exception{
		 assertEquals(successResult,userNameSuggestionService.checkUsername("jhonSmith"));
	 }
	 @Test
	 public void UserNameServiceLess6CharacteresTest()throws Exception{
		 Result result = userNameSuggestionService.checkUsername("cervantes");
	 }
	 @Test
	    public void UserNameServiceExistUsernameOnDbTest() throws Exception {
		 Result result = userNameSuggestionService.checkUsername("cervantes");
		 if (result.getSuggestedUserNames().size() != 14 && !result.getMessage().equals(userNameSuggestionServiceImpl.USER_NAME_IS_NOT_VALID)) {
	            Assert.assertTrue(false);
	        }
	 }
	 @Test
	 public void UserNameServiceWordNotAllowedTest() throws Exception {
		 String[] usernames={"vanNotAlloweds", "cervNotAllowedantes", "vNotAlloweds"};
		 for(String username:usernames){
			 Result result = userNameSuggestionService.checkUsername(username);
			 if (result.getSuggestedUserNames().size() != 14 && !result.getMessage().equals(userNameSuggestionServiceImpl.USER_NAME_IS_NOT_VALID)) {
		            Assert.assertTrue(false);
		        }
		 }
	 }
}
