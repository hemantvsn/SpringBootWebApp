package com.hemant.boot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hemant.boot.model.User;

@Controller
@RequestMapping("api/users")
public class UserController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> list() {
		return Arrays.asList(new User(1, "11111"), new User(2, "2222"));
	}

}
