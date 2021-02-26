package ru.geekbrains.spring.mvc.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.mvc.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init(){
        products=new ArrayList<>();
         products.add(new Product(1L,"AAA",100L));
        products.add(new Product(2L,"BBB",200L));
        products.add(new Product(3L,"CCC",300L));

    }

    public void addOrUpdate(Product product){
        if(product!=null){
            for(Product p:products) {
                if (p.getId()==product.getId()){
                    p.setName(product.getName());
                    p.setCost(product.getCost());
                    return;
                }
            }Product prod=product;
            prod.setId(products.get(products.size()-1).getId()+1);
            products.add(prod);
        }

    }
    public Product getById(long id){
        for(Product product:products) {
            if (product.getId()==id) return product;
        }
        return null;
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }

    public boolean deleteById(long id){
        for(Product product:products) {
            if (product.getId() == id)
            {products.remove(product);
            return true;}
        }
        return false;
    }

}