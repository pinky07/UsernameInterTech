package com.username.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.username.model.UserNameSuggestion;
import com.username.service.UserNameSuggestionService;
import com.username.vo.Result;

@Controller
@RequestMapping(value="/username")
public class UserNameSuggestionController {

	@Autowired
	 UserNameSuggestionService userNameSuggestionService;
	
	@ModelAttribute("usernamesuggestion")
	public UserNameSuggestion setUpUserForm() {
		return new UserNameSuggestion();
	}

	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("usernamesuggestion") UserNameSuggestion usernamesuggestion, Model model) {
		Result result ;
		try {
			result= userNameSuggestionService.checkUsername(usernamesuggestion.getUsername());
		} catch (Exception e) {
			result = new Result();
			 result.setMessage(e.getMessage());
			 result.setProcessResult(false);
		}
		System.out.println("result : " + result.getMessage());
		model.addAttribute("resultvaalues", result);
		 ModelAndView m = new ModelAndView("username/registrationSuccess");
		 m.addObject("resultvaalues", result);
		return m;
		

	}


	@RequestMapping(value="/")
	public String registration() {

		return "username/registrationForm";
	}

}
