package net.spd.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.shs.shoppingbackend.dao.CategoryDAO;
import net.shs.shoppingbackend.dto.Category;



@Controller
public class pageController {
	
	@Autowired
	private CategoryDAO  categoryDao;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		//add mav object to display on the console
		mv.addObject("title","Home");
		//passing the list of categories
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value= "about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		//add mav object to display on the console
		mv.addObject("title","AboutUs");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value= "contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","ContactUs");
		mv.addObject("userClickContact",true);
		return mv;
	}
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page");
		//add mav object to display on the console
		mv.addObject("title","All Products");
		//passing the list of categories
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv=new ModelAndView("page");
		//we use categoryDAO to fetch single category
		Category category=null;
		category=categoryDao.get(id);
		//add mav object to display on the console
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDao.list());
		//pass the signle category object 
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
}
