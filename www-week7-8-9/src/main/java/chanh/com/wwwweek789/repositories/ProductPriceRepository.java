package chanh.com.wwwweek789.repositories;

import chanh.com.wwwweek789.models.Product;
import chanh.com.wwwweek789.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductPriceRepository extends JpaRepository<ProductPrice, Product> {
}