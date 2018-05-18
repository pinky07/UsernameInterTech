package com.username.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
@Component
public class RestrictedWordsServiceImpl implements RestrictedWordsService {

//	@Autowired
//	private RestrictedWordsDao restrictedDao;
//	
//	@Override
//	public List listAllCustomers() {
//		return	restrictedDao.listAllCustomers();
//	}
}
