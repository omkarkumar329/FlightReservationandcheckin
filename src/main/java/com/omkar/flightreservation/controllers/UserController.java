package com.omkar.flightreservation.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omkar.flightreservation.entities.User;
import com.omkar.flightreservation.repos.UserRepository;
import com.omkar.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SecurityService securityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@RequestMapping( value = "/registerUser", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,ModelMap modelMap,@RequestParam("confirmPassword") String confirmPassword) {
		LOGGER.info("Inside register()" + user);
		if(result.hasErrors())
		{
			System.out.println(result);
			return "login/registerUser";
		}
		else  if(confirmPassword.equals(user.getPassword())) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
		}
		else 
		{   
			modelMap.addAttribute("msg","password does not matched with confirm passqord");
			return "login/registerUser";
		}

	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		LOGGER.info("Inside login() and the email is: "+email);
		
		if (user==null|| password.isBlank())
		{
			modelMap.addAttribute("nullUser","Not Valid User,Register here");
			return "login/registerUser";
		}
		boolean loginResponse = securityService.login(email, password);
		LOGGER.info("Inside login() and the email is: " + email);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid user name or password .Please try again.");
			return "login/login";
		}

		

	}
}
