package com.program.app.application.product;

import com.program.app.persistence.entity.ProductEntity;
import com.program.app.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsUseCase {

    private final ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<ProductEntity> execute() {
        return productRepository.findAll();
    }
}
