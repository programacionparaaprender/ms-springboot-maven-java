package com.program.app.web.rest;

import com.program.app.persistence.entity.ProductEntity;
import com.program.app.persistence.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Obtener todos los productos
    @GetMapping
    public Flux<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public Mono<ProductEntity> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Crear producto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }

    // Actualizar producto por ID
    @PutMapping("/{id}")
    public Mono<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        return productRepository.findById(id)
                .flatMap(existing -> {
                    product.setId(existing.getId()); // mantener ID original
                    return productRepository.save(product);
                });
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productRepository.deleteById(id);
    }
}
