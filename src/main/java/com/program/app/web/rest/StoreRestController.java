package com.program.app.web.rest;

import com.program.app.persistence.entity.StoreEntity;
import com.program.app.persistence.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/stores")
public class StoreRestController {

    private final StoreRepository storeRepository;

    public StoreRestController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Obtener todas las tiendas
    @GetMapping
    public Flux<StoreEntity> getAllStores() {
        return storeRepository.findAll();
    }

    // Obtener tienda por ID
    @GetMapping("/{id}")
    public Mono<StoreEntity> getStoreById(@PathVariable Long id) {
        return storeRepository.findById(id);
    }

    // Crear una tienda
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<StoreEntity> createStore(@RequestBody StoreEntity store) {
        return storeRepository.save(store);
    }

    // Actualizar tienda
    @PutMapping("/{id}")
    public Mono<StoreEntity> updateStore(@PathVariable Long id, @RequestBody StoreEntity store) {
        return storeRepository.findById(id)
                .flatMap(existing -> {
                    store.setId(existing.getId()); // Mantener ID original
                    return storeRepository.save(store);
                });
    }

    // Eliminar tienda
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteStore(@PathVariable Long id) {
        return storeRepository.deleteById(id);
    }
}
