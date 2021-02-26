package ru.geekbrains.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    @Autowired
ProductRepository productRepository;

    public void addOrUpdate(Product product){
        productRepository.addOrUpdate(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    public Product getById(Long id){
        return productRepository.getById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.getProducts();
    }

    public long numberOfProducts(){
        return productRepository.getProducts().size();
    }

    public long averageCost(){
        long sum=0;
        for (Product product:productRepository.getProducts())
        {
            sum+=product.getCost();
        }
        if (sum==0) return 0;
        else return sum/productRepository.getProducts().size();
    }


}
