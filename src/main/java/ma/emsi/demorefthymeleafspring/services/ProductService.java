package ma.emsi.demorefthymeleafspring.services;


import ma.emsi.demorefthymeleafspring.dao.entities.Product;
import ma.emsi.demorefthymeleafspring.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductService implements ProductManager{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        try {
            return productRepository.save(product);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Product updateProduct(Product product) {
        try {
            return productRepository.save(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean deleteProduct(Product product) {

        try {
            productRepository.delete(product);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> getAllProducts(int page,int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public List<Product> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        return productRepository.findByDesignationContains(keyword,pageable);
    }


}
