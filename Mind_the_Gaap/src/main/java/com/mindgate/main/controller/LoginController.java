package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.LoginServiceInterface;

@RestController
@RequestMapping("loginapi")
public class LoginController {

	@Autowired
	private LoginServiceInterface loginServiceInterface;
	
	// http://localhost:8082/loginapi/logins
		@RequestMapping(value = "logins" , method = RequestMethod.POST )
		public boolean addNewLogin(@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.addNewLogin(loginDetails);
		}

		@RequestMapping(value = "logins" , method = RequestMethod.PUT)
		public LoginDetails updateLogin(@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.updateLogin(loginDetails);
		}

		@RequestMapping(value = "logins/{loginId}" , method = RequestMethod.DELETE)
		public boolean deleteLogin(@PathVariable int loginId) {
			return loginServiceInterface.deleteLogin(loginId);
		}

		@RequestMapping(value = "logins/{loginId}" , method = RequestMethod.GET )
		public LoginDetails getLoginByLoginId(int loginId) {
			return loginServiceInterface.getLoginByLoginId(loginId);
		}

		@RequestMapping(value = "logins" , method = RequestMethod.GET )
		public List<LoginDetails> getAllLogins() {
			System.out.println("All Logins..!");
			return loginServiceInterface.getAllLogins();
		}
		
}
