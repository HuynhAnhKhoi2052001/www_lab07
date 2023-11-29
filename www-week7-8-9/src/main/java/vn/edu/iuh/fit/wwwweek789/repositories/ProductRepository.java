package vn.edu.iuh.fit.wwwweek789.repositories;

import vn.edu.iuh.fit.wwwweek789.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
}