package com.niit.Controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class AdminController {
	@Autowired
	private Category category;
	
	@Autowired
	private Product product;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Autowired
	private UserDetails user;

	
	@RequestMapping("/check")
	public ModelAndView Signin(@RequestParam ("name") String name,@RequestParam("password") String password)
	{
		System.out.println(name);
		boolean b;
		System.out.println("In checking Sigin page");
		ModelAndView mv = new ModelAndView("home");
		String msg;
		user = userDetailsDAO.isValidUser(name,password);
		if(user==null)
		{
			msg="Invalid User...Please try again";
		}
		else
		{
			if(name.equals("harika")&&(password.equals("harika"))){
				mv = new ModelAndView("AdminHome");
			}
			else
			{
				return new ModelAndView("HomePage");
			}
		}
		return mv;
	}
	@RequestMapping("/AddProduct")
	public ModelAndView add(@ModelAttribute("product")Product prod,BindingResult result,HttpServletRequest request)throws IOException
	{
		System.out.println("add product");
		ModelAndView mv = new ModelAndView("AddProduct");
		return mv;
	}
	@ModelAttribute
	public Product returnObject()
	{
		return new Product();
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute("product") Product p1,@RequestParam("image") MultipartFile file,Model model,HttpServletRequest request)throws IOException
	{
		ModelAndView mv = new ModelAndView("HomePage");
		String filename;
		byte[] bytes;
		System.out.println("image");
		MultipartFile image = p1.getImage();
		Path path;
		path=Paths.get("F://New folder//FrontEnd//src//main//webapp//Resources//images" + product.getName() + ".jpg");

				System.out.println("Path="+path);
		System.out.println("File name="+p1.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}
		return mv;
		
	
	
	/*@RequestMapping("/manageCategories")
	public ModelAndView Categories(){
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("Category", category);
		mv.addObject("isAdminClickedCategories","true");
		mv.addObject("CategoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/manageProducts")
	public ModelAndView Products(){
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("Product", product);
		mv.addObject("isAdminClickedProducts","true");
		mv.addObject("ProductList", productDAO.list());
		return mv;
	}
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView Suppliers(){
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("Supplier", supplier);
		mv.addObject("isAdminClickedSuppliers","true");
		mv.addObject("SupplierList", supplierDAO.list());
		return mv;
	}*/
		
}
}
	
	
	
	
	
	


