package com.program.app.web.rest;

//import com.program.app.application.CreateOrderUseCase;
import com.program.app.application.GetAllOrdersUseCase;
//import com.program.app.application.GetByIdOrderUseCase;
//import com.program.app.application.UpdateByIdOrderUseCase;
//import com.program.app.application.OrderRemovableUseCase;
import com.program.app.persistence.entity.OrdersEntity;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {

//    private final CreateOrderUseCase createOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;
//    private final GetByIdOrderUseCase getByIdOrderUseCase;
//    private final UpdateByIdOrderUseCase updateByIdOrderUseCase;
//    private final OrderRemovableUseCase orderRemovableUseCase;

    public OrdersRestController(
//            CreateOrderUseCase createOrderUseCase,
            GetAllOrdersUseCase getAllOrdersUseCase
//            GetByIdOrderUseCase getByIdOrderUseCase,
//            UpdateByIdOrderUseCase updateByIdOrderUseCase,
//            OrderRemovableUseCase orderRemovableUseCase
            ) {
//        this.createOrderUseCase = createOrderUseCase;
        this.getAllOrdersUseCase = getAllOrdersUseCase;
//        this.getByIdOrderUseCase = getByIdOrderUseCase;
//        this.updateByIdOrderUseCase = updateByIdOrderUseCase;
//        this.orderRemovableUseCase = orderRemovableUseCase;
    }

//    @PostMapping
//    public Mono<OrdersEntity> create(@RequestBody OrdersEntity order) {
//        return this.createOrderUseCase.execute(order);
//    }
//
//    @PutMapping("/{id}")
//    public Mono<OrdersEntity> update(@PathVariable Long id, @RequestBody OrdersEntity order) {
//        return this.updateByIdOrderUseCase.execute(id, order);
//    }

    @GetMapping
    public Flux<OrdersEntity> getAll() {
        return this.getAllOrdersUseCase.execute();
    }

//    @GetMapping("/{id}")
//    public Mono<OrdersEntity> getById(@PathVariable Long id) {
//        return this.getByIdOrderUseCase.execute(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<Void> deleteById(@PathVariable Long id) {
//        return this.orderRemovableUseCase.execute(id);
//    }
}
