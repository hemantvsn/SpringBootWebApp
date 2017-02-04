package com.hemant.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * This is not REST CONTROLLER.
 * If it was a rest controller, its response is directly used as output (converted to JSON)
 * But here we want it to be processed via VIEW RESOLVERS
 * Hence its a normal controller
 * All controllers barring this can be REST CONTROLLERS
 * @author hemantvsn
 * @since 0.0.1
 * 
 * 
 */

@Controller
@RequestMapping("/")
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("author", "hemantvsn");
		model.addAttribute("version", "0.0.1");
		return "index";
	}

}
