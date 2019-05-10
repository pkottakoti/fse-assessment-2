package alisnobba.searchservice.ControllerTests;




import java.util.ArrayList;
import java.util.List;

import alisnobba.searchservice.TestUtils.TestProducts;
import alisnobba.searchservice.controller.ProductController;
import alisnobba.searchservice.model.Product;
import alisnobba.searchservice.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postingProduct_savesTheProduct() throws Exception{
        Product product = TestProducts.getProducts().get(0);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(productService, times(1)).save(any(Product.class));
    }



    @Test
    public void findProductByBrand_returnsProductsWithThatBrand() throws Exception {
        //arrange
        List<Product> products = new ArrayList<>();

        products.add(TestProducts.getProducts().get(1));
        products.add(TestProducts.getProducts().get(2));

        when(productService.findByBrand("marni")).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/categories/Men"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].color", is("black")))
                .andExpect(jsonPath("$[1].color", is("black")));


        verify(productService, times(1)).findByColor("black");
        verifyNoMoreInteractions(productService);
    }
    @Test
    public void findProductByPriceRange_returnsProductsWithThatPriceRange() throws Exception {
        //arrange
        List<Product> products = new ArrayList<>();

        products.add(TestProducts.getProducts().get(1));
        products.add(TestProducts.getProducts().get(4));
        products.add(TestProducts.getProducts().get(6));

        when(productService.findByPriceRange(500.0,1000.0)).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/brand/black"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
                //.andExpect(jsonPath("$[0].price", is("marni")))


        verify(productService, times(1)).findByPriceRange(500.0,1000.0);
        verifyNoMoreInteractions(productService);
    }

}
