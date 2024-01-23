package com.example.feslegen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeslegenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeslegenApplication.class, args);
	}

	// ProductController.java

	import org.springframework.web.bind.annotation.*;

	import java.util.List;

import javax.print.PrintService;

	@RestController
	@RequestMapping("/api/products")
	public class ProductController {

	    private final ProductService productService;

	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @PostMapping
	    public void addProduct(@RequestBody Product product) {
	        productService.addProduct(product);
	    }

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @DeleteMapping("/{productId}")
	    public void deleteProduct(@PathVariable Long productId) {
	        productService.deleteProduct(productId);
	    }
	}
	// Product.java

	public class Product {

	    private Long id;
	    private String name;
	    private int stock;

	    // getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getStock() {
	        return stock;
	    }

	    public void setStock(int stock) {
	        this.stock = stock;
	    }
	}

	// ProductServiceImpl.java

	import org.springframework.stereotype.Service;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	@Service
	public class ProductServiceImpl implements ProductService {

	    private final List<Product> products = new ArrayList<>();
	    private Long idCounter = 1L;

	    @Override
	    public void addProduct(Product product) {
	        product.setId(idCounter++);
	        products.add(product);
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return products;
	    }

	    @Override
	    public void deleteProduct(Long productId) {
	        Iterator<Product> iterator = products.iterator();
	        while (iterator.hasNext()) {
	            Product product = iterator.next();
	            if (product.getId().equals(productId)) {
	                iterator.remove();
	                break;
	            }
	        }
	    }
	}

