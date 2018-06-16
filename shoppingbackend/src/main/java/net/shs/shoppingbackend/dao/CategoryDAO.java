package net.shs.shoppingbackend.dao;

import java.util.List;

import net.shs.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
