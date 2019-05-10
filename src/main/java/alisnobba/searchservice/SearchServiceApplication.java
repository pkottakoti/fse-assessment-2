package alisnobba.searchservice;

import alisnobba.searchservice.model.Product;
import alisnobba.searchservice.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class SearchServiceApplication {
    public static void main(String[] args) {
            SpringApplication.run(SearchServiceApplication.class, args);
        }

    @Bean
    CommandLineRunner runner(ProductService productService) {

        return args -> {

            // adding test data
            productService.save(new Product("dresses","gucci","red",1966.0));
            productService.save(new Product("dresses","marni","brown",999.0));
            productService.save(new Product("dresses","marni","pink",1129.0));
            productService.save(new Product("dresses","bottega veneta","black",2200.0));
            productService.save(new Product("dresses","prada","black",1650.0));
            productService.save(new Product("dresses","victoria beckham","blue",927.0));
            productService.save(new Product("dresses","celine","beige",1901.0));
            productService.save(new Product("dresses","jil sander","orange",511.0));

        };
    }

}
