package ma.emsi.demorefthymeleafspring.services;

import ma.emsi.demorefthymeleafspring.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductManager {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public boolean deleteProduct(Product product);
    public Product getProductById(Long id);
    public Page<Product> getAllProducts(int page,int size);
    public List<Product> getByKeyword(String keyword);
    public Page<Product> searchProducts(String keyword, Pageable pageable);
}
