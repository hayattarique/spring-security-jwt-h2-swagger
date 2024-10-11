package org.restapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.restapi.dto.Product;
import org.restapi.dto.ProductDetails;
import org.restapi.exception.ProductOutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/product")
@Tag(name = "Product Controller", description = "for getting product details")
public class ProductController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @Operation(summary = "this end point for getting product", description = "Get product based on manufacturer",
            responses = @ApiResponse(responseCode = "200"))
    @GetMapping("/{manufacturer}/get")
    public ResponseEntity<Product> geProduct(@PathVariable String manufacturer) {
        Product product = Product.builder().productName(" AC").manufacturer(manufacturer).category("Electronics").build();
        if ("Tata".equalsIgnoreCase(manufacturer) || "Hitachi".equalsIgnoreCase(manufacturer)) {
            throw new ProductOutOfStockException("Product is out of stock");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("/details")
    @Operation(description = "get product details", summary = "client has to send product details")
    public ResponseEntity<ProductDetails> getDetails(@RequestBody Product product) {
        ProductDetails details = new ProductDetails();
        if ("Electronics".equalsIgnoreCase(product.getCategory())) {
            throw new ProductOutOfStockException("Electronics product is out of stock");
        }
        details.setProductName(product.getProductName());
        details.setCategory(product.getCategory());
        details.setManufacturer(product.getManufacturer());
        details.setPrice(24000);
        details.setManufacturingDate(LocalDate.of(2023, 8, 24));
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

}
