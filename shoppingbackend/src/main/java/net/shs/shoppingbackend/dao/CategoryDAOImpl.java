package net.shs.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.shs.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private  SessionFactory sessionFactory;
	private static List<Category> categories=new ArrayList<>();
	static {
		//adding first category
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some descriptioon for Television");
		category.setImageURL("Cat_1.png");
		//add category to list object
		categories.add(category);
		//adding second category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("Cat_2.png");
		//add second category to list object
		categories.add(category);
		//adding third category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("Cat_3.png");
		//add third category to list object
		categories.add(category);
	}  
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		//enhanced for loop if id matched then return id otherwise return null
		for(Category category:categories){
			if(category.getId()==id)
				return category;
		}
		return null;
	}
	
	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}		

}
