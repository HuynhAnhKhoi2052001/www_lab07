package vn.edu.iuh.fit.wwwweek789.ids;


import vn.edu.iuh.fit.wwwweek789.models.Order;
import vn.edu.iuh.fit.wwwweek789.models.Product;

import java.io.Serializable;

public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
