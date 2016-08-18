package com.niit.Bookshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Homecontroller {
	
	@RequestMapping("/")
	public ModelAndView showwelcome() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;
		
	}

}
