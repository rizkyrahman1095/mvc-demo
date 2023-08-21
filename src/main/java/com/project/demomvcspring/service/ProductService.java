package com.project.demomvcspring.service;

import com.project.demomvcspring.entity.Product;
import com.project.demomvcspring.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id) {

        return repo.findById(id);

    }

    public void updateProduct(Product product) {
        repo.save(product);
    }
    public List<Product>findByName(String keyword){
        return repo.findByNameContains(keyword);
    }

}
