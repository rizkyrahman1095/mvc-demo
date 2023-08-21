package com.project.demomvcspring.repo;

import com.project.demomvcspring.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String keyword);

}
