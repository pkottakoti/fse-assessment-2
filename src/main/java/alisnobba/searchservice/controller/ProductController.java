package alisnobba.searchservice.controller;

import alisnobba.searchservice.model.Product;
import alisnobba.searchservice.repository.ProductRepository;
import alisnobba.searchservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    ProductService productService;
    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/products/addProduct")
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/products/filter/brand/{brand}")
    public List<Product> findByBrand(@PathVariable String brand){
        return productService.findByBrand(brand);

    }
    @GetMapping("/products/filter/color/{color}")
    public List<Product> findByColor(String color){
        return productService.findByColor(color);
    }
    @GetMapping("/products/filter/range/{low}/{high}")
    public List<Product> findByPriceRange(@PathVariable double low, @PathVariable double high){
        return productService.findByPriceRange(low,high);

    }
}
