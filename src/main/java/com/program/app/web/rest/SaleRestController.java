package com.program.app.web.rest;

import com.program.app.persistence.entity.SaleEntity;
import com.program.app.persistence.repository.SaleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sales")
public class SaleRestController {

    private final SaleRepository saleRepository;

    public SaleRestController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    // Obtener todas las ventas
    @GetMapping
    public Flux<SaleEntity> getAllSales() {
        return saleRepository.findAll();
    }

    // Obtener venta por ID
    @GetMapping("/{id}")
    public Mono<SaleEntity> getSaleById(@PathVariable Long id) {
        return saleRepository.findById(id);
    }

    // Crear una venta
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SaleEntity> createSale(@RequestBody SaleEntity sale) {
        return saleRepository.save(sale);
    }

    // Actualizar una venta por ID
    @PutMapping("/{id}")
    public Mono<SaleEntity> updateSale(@PathVariable Long id, @RequestBody SaleEntity sale) {
        return saleRepository.findById(id)
                .flatMap(existing -> {
                    sale.setId(existing.getId()); // mantener el ID original
                    return saleRepository.save(sale);
                });
    }

    // Eliminar una venta por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSale(@PathVariable Long id) {
        return saleRepository.deleteById(id);
    }
}
