package alisnobba.searchservice.ServiceTests;




import alisnobba.searchservice.model.Product;
import alisnobba.searchservice.repository.ProductRepository;
import alisnobba.searchservice.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    public void saveProduct_savesTheProduct() {
        //arrange
        Product product = new Product("dresses","jil sander","orange",511.0);

        //act
        productService.save(product);

        //assert
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void findProductByBrand_returnsProductsWithThatBrand(){
        String brand="marni";
        productService.findByBrand(brand);
        //assert
        verify(productRepository, times(1)).findByBrand(brand);
    }
    @Test
    public void findProductByColor_returnsProductsWithThatColor(){
        String color="black";
        productService.findByColor(color);
        //assert
        verify(productRepository, times(1)).findByBrand(color);
    }

    @Test
    public void findProductByPriceRange_returnsProductsWithThatPriceRange(){
        double low=500.0,high=1000.0;
        productService.findByPriceRange(low,high);
        //assert
        verify(productRepository, times(1)).findByPriceRange(low,high);
    }


}
