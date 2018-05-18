package com.username.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.username.dao.RestrictedWordsDao;
import com.username.dao.UserNameSuggestionDao;
import com.username.model.RestrictedWords;
import com.username.model.UserNameSuggestion;
import com.username.vo.Result;

@Service
@Transactional
@Component
public class UserNameSuggestionServiceImpl implements UserNameSuggestionService {

	@Autowired
	private RestrictedWordsDao restrictedDao;
	@Autowired
	private UserNameSuggestionDao userNameSuggestionDao;

	public static String NOT_CONTAINS_6_CHARACTERS = "username not conatin 6 character";
	public static String CONTAINS_RESTRICTED_WORD = "User name contains a restricted word";
	public static String ALREADY_EXIST_IN_DATABASE = "User name is already exist in DB";
	public static String USER_NAME_IS_VALID = "User name is valid";
	public static String USER_NAME_IS_NOT_VALID = "User name is not valid";

	

	@Override
	public Result checkUsername(String username) throws Exception {
		Result result = new Result();
		List<String> error = new ArrayList<String>();

		if (StringUtils.isBlank(username) || username.length() < 6) {

			throw new Exception(NOT_CONTAINS_6_CHARACTERS);
		}

		if (StringUtils.isNotBlank(userNameHasRestrictedWord(username))) {
			error.add(CONTAINS_RESTRICTED_WORD);
			result.setMessage(error.toString());
			username = removeRestrictedWords(username);
		}

		if (existUserNameOnDatabase(username)) {
			result.setSuggestedUserNames(generateUsernames(removeRestrictedWords(username)));
			error.add(ALREADY_EXIST_IN_DATABASE);

		}
		if (error.isEmpty()) {
			result.setMessage(USER_NAME_IS_VALID);
			result.setProcessResult(true);
			UserNameSuggestion user = new UserNameSuggestion();
			user.setUsername(username);
			userNameSuggestionDao.saveOrUpdate(user);

		} else {
			result.setMessage(USER_NAME_IS_NOT_VALID);
			result.setProcessResult(false);
			result.setSuggestedUserNames(generateUsernames(removeRestrictedWords(username)));
		}
		return result;
	}

	private String removeRestrictedWords(String username) {
		String notAllowed = userNameHasRestrictedWord(username);
		if (StringUtils.isBlank(notAllowed)) {
			return username;
		} else
			return StringUtils.remove(username, notAllowed);
	}

	public boolean existUserNameOnDatabase(String username) {
		List<UserNameSuggestion> usernameList = userNameSuggestionDao.findByUserName(username);
		if (usernameList.isEmpty() || usernameList == null) {
			return false;
		} else
			return true;
	}

	public String userNameHasRestrictedWord(String username) {
		List<RestrictedWords> restrictedWordsOnDb = restrictedDao.findAll();
		String showRestrictedWord = StringUtils.EMPTY;
		// check empty list
		if (restrictedWordsOnDb.isEmpty() || restrictedWordsOnDb == null) {
			System.out.println("Restricted words no exist on db");
		} else {
			for (RestrictedWords restedword : restrictedWordsOnDb) {

				if (StringUtils.contains(username, restedword.getWord())) {
					System.out.println("found restrictd words" + restedword.getWord());
					showRestrictedWord = restedword.getWord();
					// break;
				}
			}
		}
		return showRestrictedWord;
	}

	public TreeSet<String> generateUsernames(String username) {
		TreeSet<String> treeset = new TreeSet<String>();
		StringBuffer sb = new StringBuffer();
		String concat = "";

		for (int i = 0; i < 15; i++) {
			sb = sb.append(username).append(i).append('\n');
			//treeset.add(sb.toString());
			
			if (checkIsValidUserNameGenerated(sb.toString()))
				treeset.add(sb.toString());
			sb.setLength(0);
		}
		return treeset;
	}

	@Override
	public void saveOrUpdate(UserNameSuggestion username) {
		userNameSuggestionDao.saveOrUpdate(username);

	}

	public boolean checkIsValidUserNameGenerated(String username) {
		if (existUserNameOnDatabase(username)) {
			return false;
		} else
			return true;
	}
}