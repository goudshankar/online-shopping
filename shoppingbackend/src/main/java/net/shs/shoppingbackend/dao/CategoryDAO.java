package net.shs.shoppingbackend.dao;

import java.util.List;

import net.shs.shoppingbackend.dto.Category;

public interface CategoryDAO {
	boolean add(Category category);
	List<Category> list();
	Category get(int id);
}
