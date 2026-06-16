package com.program.app.web.rest;

//import com.program.app.application.CreateDisputeUseCase;
import com.program.app.application.GetAllDisputesUseCase;
//import com.program.app.application.GetByIdDisputeUseCase;
//import com.program.app.application.UpdateByIdDisputeUseCase;
//import com.program.app.application.DisputeRemovableUseCase;
import com.program.app.persistence.entity.DisputeEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/disputes")
public class DisputeRestController {

//    private final CreateDisputeUseCase createDisputeUseCase;
    private final GetAllDisputesUseCase getAllDisputesUseCase;
//    private final GetByIdDisputeUseCase getByIdDisputeUseCase;
//    private final UpdateByIdDisputeUseCase updateByIdDisputeUseCase;
//    private final DisputeRemovableUseCase disputeRemovableUseCase;

    public DisputeRestController(
//            CreateDisputeUseCase createDisputeUseCase,
            GetAllDisputesUseCase getAllDisputesUseCase
//            GetByIdDisputeUseCase getByIdDisputeUseCase,
//            UpdateByIdDisputeUseCase updateByIdDisputeUseCase,
//            DisputeRemovableUseCase disputeRemovableUseCase
    ) {
//        this.createDisputeUseCase = createDisputeUseCase;
        this.getAllDisputesUseCase = getAllDisputesUseCase;
//        this.getByIdDisputeUseCase = getByIdDisputeUseCase;
//        this.updateByIdDisputeUseCase = updateByIdDisputeUseCase;
//        this.disputeRemovableUseCase = disputeRemovableUseCase;
    }

    // Crear nueva disputa
//    @PostMapping
//    public Mono<DisputeEntity> create(@RequestBody DisputeEntity disputeEntity) {
//        return this.createDisputeUseCase.execute(disputeEntity);
//    }
//
//    // Actualizar disputa por id
//    @PutMapping("/{id}")
//    public Mono<DisputeEntity> update(@PathVariable Long id, @RequestBody DisputeEntity disputeEntity) {
//        return this.updateByIdDisputeUseCase.execute(id, disputeEntity);
//    }

    // Listar todas las disputas
    @GetMapping
    public Flux<DisputeEntity> getAll() {
        return this.getAllDisputesUseCase.execute();
    }

    // Obtener disputa por id
//    @GetMapping("/{id}")
//    public Mono<DisputeEntity> getById(@PathVariable Long id) {
//        return this.getByIdDisputeUseCase.execute(id);
//    }
//
//    // Eliminar disputa por id
//    @DeleteMapping("/{id}")
//    public Mono<Void> deleteById(@PathVariable Long id) {
//        return this.disputeRemovableUseCase.execute(id);
//    }
}
