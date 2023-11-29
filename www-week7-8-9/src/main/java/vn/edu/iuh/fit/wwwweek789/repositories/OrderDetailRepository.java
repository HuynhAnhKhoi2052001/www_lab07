package vn.edu.iuh.fit.wwwweek789.repositories;

import vn.edu.iuh.fit.wwwweek789.models.Order;
import vn.edu.iuh.fit.wwwweek789.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {
}