package org.productcrudapp.service;
import java.util.List;
import java.util.Optional;

import org.productcrudapp.model.Product;
import org.productcrudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("prodService")
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	public boolean isAddProduct(Product product) 
	{
		Product e=prodRepo.save(product);
		return e!=null?true:false;
	}
	
	public List<Product> getAllProducts() 
	{
		List<Product> list=prodRepo.findAll();
		return list;
	}
	
	public Product getProductById(int id) 
	{
		Optional<Product> o=prodRepo.findById(id);
		return o.isEmpty()?null:o.get();
	}
	
	public String deleteProductById(int id) 
	{
		Optional<Product> o=prodRepo.findById(id);
		if(o.isEmpty())
		{
			return "Product not found";
	    }
		else
		{
			prodRepo.deleteById(id);
			return "Product Deleted Successfully....";
		}
	}
	
	public String updateProduct(int id, Product prod) {
		Optional<Product> o = prodRepo.findById(id);

		if (o.isPresent()) {
			Product newProd = o.get();
			newProd.setName(prod.getName());
			newProd.setPrice(prod.getPrice());
			newProd.setCategory(prod.getCategory());
			prodRepo.save(newProd);
			return "Product updated Successfully....";
		} else {
			return "Product Not updated....";
		}

	}
}
