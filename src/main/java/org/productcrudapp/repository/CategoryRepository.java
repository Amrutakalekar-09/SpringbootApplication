package org.productcrudapp.repository;

import org.productcrudapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("catRepo")
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}

