package chanh.com.wwwweek789.repositories;

import chanh.com.wwwweek789.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}