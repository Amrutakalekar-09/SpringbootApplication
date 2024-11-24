package org.productcrudapp.service;
import java.util.List;
import java.util.Optional;

import org.productcrudapp.model.Category;
import org.productcrudapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("catService")
public class CategoryService {
	
	@Autowired
	CategoryRepository catRepo;
	
	public boolean isAddCategory(Category category) 
	{
		Category e=catRepo.save(category);
		return e!=null?true:false;
	}
	
	public List<Category> getAllCategory() 
	{
		List<Category> list=catRepo.findAll();
		return list;
	}
	
	public Category getCategoryById(int id) 
	{
		Optional<Category> o=catRepo.findById(id);
		return o.isEmpty()?null:o.get();
	}
	
	public String deleteCategoryById(int id) 
	{
		Optional<Category> o=catRepo.findById(id);
		if(o.isEmpty())
		{
			return "Category not found";
	    }
		else
		{
			catRepo.deleteById(id);
			return "Category Deleted Successfully....";
		}
	}
	
	public String updateCategory(int id, Category cat) {
		Optional<Category> o = catRepo.findById(id);

		if (o.isPresent()) {
			Category newCat = o.get();
			newCat.setName(cat.getName());
			catRepo.save(newCat);
			return "Category updated Successfully....";
		} else {
			return "Category Not updated....";
		}

	}
}
