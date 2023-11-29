package vn.edu.iuh.fit.wwwweek789.repositories;

import vn.edu.iuh.fit.wwwweek789.models.Product;
import vn.edu.iuh.fit.wwwweek789.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductPriceRepository extends JpaRepository<ProductPrice, Product> {
}