package com.niit.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {

	@Autowired(required = true)
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired

	private Category category;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());

		return "product";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addproduct(@Valid @ModelAttribute("product") Product product, Model model, BindingResult result,
			HttpServletRequest request) throws IOException {

		String filename;

		byte[] bytes;
		System.out.println(product.getName());

		System.out.println("image uploaded");

		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();
		Path path;
		path = Paths.get("F://New folder//FrontEnd//src//main//webapp//Resources//images//" + product.getName() + ".jpg");

		System.out.println("Path = " + path);
		System.out.println("File name = " + product.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}
		ModelAndView mv = new ModelAndView("product");
		Category category = categoryDAO.get(product.getCategory().getId());
		// categoryDAO.save(category);
		product.setCategory(category);
		product.setCatid(category.getId());
		productDAO.save(product);
		mv.addObject("productList",productDAO.list());

		return "product";
	}

	@RequestMapping("product/delete/{id}")
	public String deleteSupplier(@ModelAttribute("product") Product product) throws Exception {

		ModelAndView mv = new ModelAndView("product");

		if (product == null)

		{
			mv.addObject("error messaege", "could not delete the supplier");
		} else {
			productDAO.delete(product);
		}
		mv.addObject("productList",productDAO.list());
		return "product";
	}

	@RequestMapping(value="product/update/{id}", method = RequestMethod.GET)
	public String updateSupplier(@PathVariable("id") String id, Model model) {
		ModelAndView mv = new ModelAndView("product");

		System.out.println("update supplier");
		model.addAttribute("supplier", this.productDAO.get(id));
		model.addAttribute("listSuppliers", this.productDAO.list());
		mv.addObject("productList",productDAO.list());

		return "product";

	}

}
