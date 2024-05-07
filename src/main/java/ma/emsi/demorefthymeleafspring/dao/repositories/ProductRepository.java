package ma.emsi.demorefthymeleafspring.dao.repositories;

import jakarta.transaction.Transactional;
import ma.emsi.demorefthymeleafspring.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByNameContains(String keyword, Pageable pageable);

    Page<Product> findByDesignationContains(String keyword, Pageable pageable);
}
