package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.EmailSenderService;
import com.mindgate.main.service.LoginServiceInterface;

@RestController
@RequestMapping("loginCRUDapi")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private LoginServiceInterface loginServiceInterface;
	
	
	
	@Autowired
    private EmailSenderService emailSenderService;
    
    @RequestMapping(value = "send",method = RequestMethod.POST)
    public boolean sendMail(@RequestBody LoginDetails login) {
    	int loginId=login.getLoginId();
    	String loginIdNew=Integer.toString(loginId);
    	String message="Your Account Approved From Apex Bank "+"\n \n"+" Your Default Password : PASSWORD123 \n \n Your LoginId : "+loginIdNew;
        emailSenderService.sendEmail(login.getCustomerId().getEmail(),"Account Login Credentials - Apex Bank ",message);
    // emailSenderService.sendEmail("rajifalitmv@gmail.com","confirmation","this is new email sent by rajif");
        System.out.println("email sent");
        return true;
    }
	
	// http://localhost:8081/loginCRUDapi/logins
		@RequestMapping(value = "logins" , method = RequestMethod.POST )
		public boolean addNewLogin(@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.addNewLogin(loginDetails);
		}

		// http://localhost:8081/loginCRUDapi/login
		@RequestMapping(value = "login" , method = RequestMethod.PUT)
		public LoginDetails updateLogin(@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.updateLogin(loginDetails);
		}

		@RequestMapping(value = "login/{loginId}" , method = RequestMethod.DELETE)
		public boolean deleteLogin(@PathVariable int loginId) {
			return loginServiceInterface.deleteLogin(loginId);
		}
		
		// http://localhost:8081/loginCRUDapi/login/details
		@RequestMapping(value = "login/details" , method = RequestMethod.POST )
		public LoginDetails getLoginByLoginId(@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.getLoginByLoginId(loginDetails);
		}
		 
		@RequestMapping(value = "logins" , method = RequestMethod.GET )
		public List<LoginDetails> getAllLogins() {
			System.out.println("All Logins..!");
			return loginServiceInterface.getAllLogins();
		}
		
		@RequestMapping(value= "logins/l", method = RequestMethod.POST)

        public LoginDetails loginLoginOnePassword(@RequestBody LoginDetails loginDetails) {
            return loginServiceInterface.loginCount(loginDetails);
        }
		
		@RequestMapping(value = "setLogin" , method = RequestMethod.POST )
		public LoginDetails setloginByCustomerId (@RequestBody LoginDetails loginDetails) {
			return loginServiceInterface.setLoginByCustomerId(loginDetails);
		}
		
		@RequestMapping(value= "adminLogin", method = RequestMethod.POST)
        public boolean getAdminbyAdminId(@RequestBody LoginDetails loginDetails) {
            return loginServiceInterface.getAdminLoginByAdminLoginId(loginDetails);
        }

		@RequestMapping(value = "admin/count/{loginId}" , method = RequestMethod.GET)
		public boolean setCountPasswordType(@PathVariable int loginId) {
			return loginServiceInterface.setLoginCountPasswordType(loginId);
		}
		
		@RequestMapping(value = "loginaccountsByStatus", method = RequestMethod.GET)
		public List<LoginDetails> getLoginsByStatusBlocked(){
			return loginServiceInterface.getLoginsByLoginStatusBlocked();
		}
		
		@RequestMapping(value = "admin/logindetails/{loginId}", method = RequestMethod.GET)
		public LoginDetails accountOne(@PathVariable int loginId) {
			return loginServiceInterface.AdminGetLoginByLoginId(loginId);
		}
		
		@RequestMapping(value = "logindetails/customer/{customerId}", method = RequestMethod.GET)
		public LoginDetails getLoginByCustomerId(@PathVariable int customerId) {
			return loginServiceInterface.getLoginByCustomerId(customerId);
		}
		

		
}
