package alisnobba.searchservice.TestUtils;


import alisnobba.searchservice.model.Product;

import java.util.ArrayList;
import java.util.List;

public class TestProducts {
    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("dresses","gucci","red",1966.0));
        products.add(new Product("dresses","marni","brown",999.0));
        products.add(new Product("dresses","marni","pink",1129.0));
        products.add(new Product("dresses","bottega veneta","black",2200.0));
        products.add(new Product("dresses","prada","black",1650.0));
        products.add(new Product("dresses","victoria beckham","blue",927.0));
        products.add(new Product("dresses","celine","beige",1901.0));
        products.add(new Product("dresses","jil sander","orange",511.0));
        return products;
    }
}

