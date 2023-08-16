package com.project.demomvcspring.service;

import com.project.demomvcspring.entity.Product;
import com.project.demomvcspring.util.RandomNum;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public static List<Product> products = new ArrayList<Product>() {
        {
            add(new Product(RandomNum.getRandom(1000,9999), "001", "indomie", 30000.0));
            add(new Product(RandomNum.getRandom(1000,9999), "002", "jagung", 28000.0));
            add(new Product(RandomNum.getRandom(1000,9999), "003", "teh", 31000.0));
            add(new Product(RandomNum.getRandom(1000,9999), "004", "thai'thea", 33000.0));
            add(new Product(RandomNum.getRandom(1000,9999), "005", "miegoreng", 34000.0));
            add(new Product(RandomNum.getRandom(1000,9999), "006", "mierebus", 36000.0));
        }
    };

    public static List<Product> findAll() {
        return products;

    }

    public void addProduct(Product product) {
        product.setId(RandomNum.getRandom(1000,9999));
        products.add(product);
    }
    public void deleteById(long id){
        products.removeIf(i -> i.getId() == id);
    }
    public Optional<Product> findById(long id){

        return products.stream().filter(p -> p.getId()==id).findFirst();

    }

}
