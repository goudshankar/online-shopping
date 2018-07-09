package net.shs.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.shs.shoppingbackend.dao.CategoryDAO;
import net.shs.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.shs.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	@Test
	public  void TestAddCategory() {
		category =new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("Cat_15.png");
		assertEquals("successfully added category inside the table",true,categoryDAO.add(category)); 
	}
}
