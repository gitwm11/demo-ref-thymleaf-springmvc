package ma.emsi.demorefthymeleafspring;

import ma.emsi.demorefthymeleafspring.dao.entities.Product;
import ma.emsi.demorefthymeleafspring.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoRefThymeleafSpringApplication {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(
                DemoRefThymeleafSpringApplication.class, args
        );
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product product1 = new Product(null,"prod1",14.25,new Date());
            Product product2 = new Product(null,"prod2",24.25,new Date());
            Product product3 = new Product(null,"prod3",18.25,new Date());
            Product product4 = new Product(null,"prod4",11.25,new Date());

            productRepository.saveAll(
                    List.of(product1,product2,product3,product4)
            );
        };
    }

}
