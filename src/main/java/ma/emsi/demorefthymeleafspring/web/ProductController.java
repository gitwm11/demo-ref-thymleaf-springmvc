package ma.emsi.demorefthymeleafspring.web;


import lombok.AllArgsConstructor;
import ma.emsi.demorefthymeleafspring.dao.entities.Product;
import ma.emsi.demorefthymeleafspring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {


    private ProductService productService;

    @GetMapping(path = "/index")
    public String products(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Product> pageProducts = productService.searchProducts(keyword,PageRequest.of(page,size));
        model.addAttribute("listProducts",pageProducts.getContent());
        model.addAttribute("pages",new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage",page);


        return "products";
    }


}
