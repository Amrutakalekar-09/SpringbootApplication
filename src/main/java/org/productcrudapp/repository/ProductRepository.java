package org.productcrudapp.repository;
import org.productcrudapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("prodRepo")
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
}
