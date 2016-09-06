package com.niit.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class HomeController {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;


	
	@RequestMapping("/")
	public ModelAndView showindex()
	{
		System.out.println("test1");
		ModelAndView mv = new ModelAndView("HomePage");
				mv.addObject("message,Hello World");
				return mv;
	}
	@RequestMapping("/Signin")
	public ModelAndView showsignin(){
	ModelAndView mv = new ModelAndView("Signin");
	return mv;
	
	
	}
	@RequestMapping("/Signup")
	public ModelAndView showsignup(@Valid @ModelAttribute("UserDetails")UserDetails user,BindingResult result,HttpServletRequest request)throws IOException
	{
		ModelAndView mv = new ModelAndView("Signup");
				mv.addObject("message,Signup");
				return mv;
	}
	@ModelAttribute
	public UserDetails returnObject()
	{
		return new UserDetails();
	}

	@RequestMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("UserDetails")UserDetails user,BindingResult result,HttpServletRequest request)throws IOException
	{
		System.out.println(user.getPassword());
		System.out.println(user.getConfirmpassword());
		ModelAndView mv = new ModelAndView("Signin");
		user.setRole("ROLE_USER");
		if(user.getConfirmpassword().equals(user.getPassword()))
				{
			userDetailsDAO.save(user);
				}
		return mv;
	}
	/*@RequestMapping("/check")
	public ModelAndView Signin(@RequestParam ("name") String name,@RequestParam("password") String password)
	{
		System.out.println(name);
		boolean b;
		System.out.println("In checking Sigin page");
		ModelAndView mv = new ModelAndView("home");
		
		if(name.equals("harika")&&(password.equals("harika"))){
			b=true;
		}
		else
		{
			System.out.println("invalid user please enter valid credentials");
			b=false;
		}
		if(b==true)
		{
			mv = new ModelAndView("HomePage");
		}
		else
		{
			return new ModelAndView("Signin");
		}
		return mv;
	}*/
	
	
	

}
