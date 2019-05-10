package alisnobba.searchservice.RepositoryTests;



import alisnobba.searchservice.TestUtils.TestProducts;
import alisnobba.searchservice.model.Product;
import alisnobba.searchservice.repository.ProductRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void repoSavesInDB() throws Exception {
        Product product = TestProducts.getProducts().get(0);

        Integer id = testEntityManager.persistAndGetId(product, Integer.class);
        Product foundProduct = productRepository.findById(id).orElse(null);
        assertThat(foundProduct.getBrand()).isEqualTo(product.getBrand());
    }

    @Test
    public void findProductByBrand_returnsProductsWithThatBrand(){
        String brand="marni";

        int size = productRepository.findByBrand(brand).size();
        assertThat(size==2);

    }
    @Test
    public void findProductByColor_returnsProductsWithThatColor(){
        String color="black";

        int size = productRepository.findByColor(color).size();
        assertThat(size==2);

    }
    @Test
    public void findProductByPriceRange_returnsProductsWithThatPriceRange(){
        double low=500.0,high=1000.0;

        int size = productRepository.findByPriceRange(low,high).size();
        assertThat(size==3);

    }
}

