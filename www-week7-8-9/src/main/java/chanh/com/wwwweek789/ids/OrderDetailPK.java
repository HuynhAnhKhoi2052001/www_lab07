package chanh.com.wwwweek789.ids;


import chanh.com.wwwweek789.models.Order;
import chanh.com.wwwweek789.models.Product;

import java.io.Serializable;

public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
