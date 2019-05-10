package alisnobba.searchservice.repository;

import alisnobba.searchservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product p where p.brand = ?1 ", nativeQuery = true)
    public List<Product> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from product p where p.color = ?1 ", nativeQuery = true)
    public List<Product> findByColor(@Param("color") String color);

    @Query(value = "select * from product p where p.price BETWEEN ?1 and ?2 ", nativeQuery = true)
    public List<Product> findByPriceRange(@Param("low") double low, @Param("high") double high);

}


