package chanh.com.wwwweek789.repositories;

import chanh.com.wwwweek789.models.Order;
import chanh.com.wwwweek789.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {
}