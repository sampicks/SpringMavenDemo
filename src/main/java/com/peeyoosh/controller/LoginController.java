package com.peeyoosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.peeyoosh.service.UserAuthService;

@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired	// Set the instance by spring - auto wiring
	UserAuthService userAuthService;

	/**
	 * 1. Anything starts with /spring-mvc/* url it goes to dispatcher servlet. 
	 * 2. /hello with redirect to sayHello() method defined in LoginController 
	 * 3. since @ResponseBody is defined, string will be returned as response to
	 * browser.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello Spring mvc"; // If we don't provide @ResponseBody then "Hello Spring mvc" will be considered
									// as url of the response file rather than as response text.
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "LoginSpringMvc"; // url of the response file
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (userAuthService.isUserValid(name, password)) {
			/**
			 * whatever you put in the model, dispatcher servlet make it (modelmap)
			 * available to view i.e. jsp file.
			 * Also it available into session scope.
			 */
			model.put("username", name);
			return "Welcome";
		} else {
			model.put("errorMessage", "Invalid user credentials!!!");
			return "LoginSpringMvc";
		}

	}
}
