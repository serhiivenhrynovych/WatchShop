package ua.com.serhii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.serhii.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("from Product pr where pr.productName=:productName")
    Product findByName(@Param("productName") String productName);

}
