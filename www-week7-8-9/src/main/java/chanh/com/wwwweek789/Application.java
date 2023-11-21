package chanh.com.wwwweek789;

import chanh.com.wwwweek789.enums.ProductStatus;
import chanh.com.wwwweek789.models.Product;
import chanh.com.wwwweek789.models.ProductImage;
import chanh.com.wwwweek789.models.ProductPrice;
import chanh.com.wwwweek789.repositories.ProductImageRepository;
import chanh.com.wwwweek789.repositories.ProductPriceRepository;
import chanh.com.wwwweek789.repositories.ProductRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner createDataProduct() {
        return args -> {
            Faker faker = new Faker();
            Random rnd = new Random();
            Device devices = faker.device();
            for (int i = 0; i < 200; i++) {

                Product product = new Product(
                        devices.modelName(),
                        faker.lorem().paragraph(2), "piece", devices.manufacturer(),
                        ProductStatus.ACTIVE
                );
                ProductImage img = new ProductImage("assets/sp.png", "sample img");
                img.setProduct(product);
                ProductPrice price = new ProductPrice(LocalDateTime.now(), rnd.nextInt(1500), "Note #" + i);
                price.setProduct(product);
                product.setProductImageList(List.of(img));
                product.setProductPrices(List.of(price));
                productRepository.save(product);
            }


        };
    }
}