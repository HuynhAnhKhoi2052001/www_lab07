package vn.edu.iuh.fit.wwwweek789.controllers;

import vn.edu.iuh.fit.wwwweek789.enums.ProductStatus;
import vn.edu.iuh.fit.wwwweek789.models.CartItem;
import vn.edu.iuh.fit.wwwweek789.models.Product;
import vn.edu.iuh.fit.wwwweek789.repositories.ProductRepository;
import vn.edu.iuh.fit.wwwweek789.services.ProductServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    private String showProductList(
            HttpSession session,
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Product> productPage = productServices.findPaginate(page - 1, size, "name", "asc");
        model.addAttribute("productPage", productPage);
        if (productPage.getTotalPages() > 0) {
            model.addAttribute("pageNumbers", IntStream.rangeClosed(1, productPage.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList()));
        }
        return "admin/product/list";
    }


    //show form add
    @GetMapping("/products/show-add-form")
    public String showFormAdd(Model model) {
        Product product = new Product();
        model.addAttribute("productAdd", product);
        model.addAttribute("statuses", ProductStatus.values());
        return "admin/product/add";
    }
    //add
    @PostMapping("/products/add")
    public String addProduct(
            @ModelAttribute("productAdd") Product Product,
            BindingResult result, Model model) {
        productRepository.save(Product);
        return "redirect:/products";
    }

    //delete
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        productRepository.delete(product);
        return "redirect:/products";
    }

    //show form edit
    @GetMapping("/products/show-edit-form/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product Product = productRepository.findById(id).orElse(null);
        model.addAttribute("productUpdate", Product);
        model.addAttribute("statuses", ProductStatus.values());
        return "admin/product/update"; // Trả về view hiển thị form cập nhật thông tin khách hàng
    }

    //update
    @PostMapping("/products/update/{id}")
    public String updateCustomer(@PathVariable("id") long id,
                                 @ModelAttribute("productUpdate") Product updateProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(updateProduct.getName());
            product.setDescription(updateProduct.getDescription());
            product.setUnit(updateProduct.getUnit());
            product.setManufacturer(updateProduct.getManufacturer());
            product.setStatus(updateProduct.getStatus());


            productRepository.save(product);
        }
        return "redirect:/products";
    }

    // addcart
    @GetMapping("/products/add2cart/{id}")
    private String add2Cart(HttpSession session, Model model, @PathVariable("id") long id) {
        Object obj = session.getAttribute("items");
        Product product = productRepository.findById(id).get();
        HashMap<Long, CartItem> cart = null;
        if (obj == null)
            cart = new HashMap<>();
        else
            cart = (HashMap<Long, CartItem>) obj;
        CartItem item = new CartItem(product, 1);
        if (cart.get(product.getProduct_id()) != null) ;
        item.setAmount(item.getAmount() + 1);
        cart.put(product.getProduct_id(), item);
        session.setAttribute("items", cart);
        session.setAttribute("itemsOnCart", cart.size());
        return "redirect:/products";
    }
}
