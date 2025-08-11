package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.entities.dto.ProductAddDto;
import com.works.repositories.ProductRepository;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("add")
    public Product addProduct(@Valid @RequestBody ProductAddDto productAddDto) {
        return productService.addProduct(productAddDto);
    }

    @GetMapping("list")
    public List<Product> productList() {
        return productService.findAll();
    }

}
