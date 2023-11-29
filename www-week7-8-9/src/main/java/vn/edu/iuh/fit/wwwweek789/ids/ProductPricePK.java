package vn.edu.iuh.fit.wwwweek789.ids;

import vn.edu.iuh.fit.wwwweek789.models.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime price_date_time;
}
