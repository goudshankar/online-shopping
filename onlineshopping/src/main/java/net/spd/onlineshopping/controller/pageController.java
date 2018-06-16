package net.spd.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.shs.shoppingbackend.dao.CategoryDAO;


	
	

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
	
	@RequestMapping(value= {"about"})
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		//add mav object to display on the console
		mv.addObject("title","AboutUs");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value= {"contact"})
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","ContactUs");
		mv.addObject("userClickContact",true);
		return mv;
	}
}
