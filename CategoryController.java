package com.niit.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller

public class CategoryController {

	private static Logger Log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {

		Log.debug("starting of the method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		Log.debug("End of the method listCategories");
		return "category";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ModelAndView addCategory(Model model) {
		Log.debug("starting of the method addCategory");

		ModelAndView mv = new ModelAndView();

		if(categoryDAO.get(category.getId()) != null)
		{
			
			categoryDAO.save(category);
		} 
		else 
		{
			mv.addObject("error message,if exists with this id" + category.getId());
		}
		Log.debug("ending of the method addcategories");
		return mv;

	}

	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id) throws Exception {
		category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("category");
		if (category == null) {
			mv.addObject("errorMessage", "could not delete the category");
		} else {
			categoryDAO.delete(category);
		}
		return mv;
	}

	@RequestMapping(value = "category/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("category") Category category) {
		ModelAndView mv = new ModelAndView();

		if (categoryDAO.get(category.getId()) != null) {
			categoryDAO.update(category);
			mv.addObject("message", "Successfully updated");

		} else {
			mv.addObject("errorMessage", "could update the record");
		}
		return mv;
	}

}
