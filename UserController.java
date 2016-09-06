/*package com.niit.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class UserController {

	// when the user clicked login
	// based on the credentials,I want to find wether he is admin or not
	// if he is admin,I want to navigate to adminHome Page
	// if it is User,I want to navigate to home page
	// if the user does not exist with this credentials,i want to give error
	// message

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	UserDetails userDetails;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "id") int id,
			@RequestParam(value = "password") String password,HttpSession session) {
		ModelAndView mv = new ModelAndView("home");
		String msg;
		if (userDetailsDAO.isValidUser(name, password) == null) {
			msg = "Ivalid User...please try again";
		} else {
			if (userDetails.getRole().equals("ROLE_ADMIN")) {
				mv = new ModelAndView("adminHome");
			} else 
			{
              session.setAttribute("welcomeMsg",userDetails.getName());
              session.setAttribute("userID",userDetails.getId());
              
			}
		}
		return mv;

	}

}
*/