package com.program.app.web.rest;

//import com.program.app.application.CreateMessageUseCase;
import com.program.app.application.GetAllMessagesUseCase;
//import com.program.app.application.GetByIdMessageUseCase;
//import com.program.app.application.UpdateByIdMessageUseCase;
//import com.program.app.application.MessageRemovableUseCase;
import com.program.app.persistence.entity.MessageEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

//    private final CreateMessageUseCase createMessageUseCase;
    private final GetAllMessagesUseCase getAllMessagesUseCase;
//    private final GetByIdMessageUseCase getByIdMessageUseCase;
//    private final UpdateByIdMessageUseCase updateByIdMessageUseCase;
//    private final MessageRemovableUseCase messageRemovableUseCase;

    public MessageRestController(
//    		CreateMessageUseCase createMessageUseCase,
                                 GetAllMessagesUseCase getAllMessagesUseCase
//                                 GetByIdMessageUseCase getByIdMessageUseCase,
//                                 UpdateByIdMessageUseCase updateByIdMessageUseCase,
//                                 MessageRemovableUseCase messageRemovableUseCase
                                 ) {
//        this.createMessageUseCase = createMessageUseCase;
        this.getAllMessagesUseCase = getAllMessagesUseCase;
//        this.getByIdMessageUseCase = getByIdMessageUseCase;
//        this.updateByIdMessageUseCase = updateByIdMessageUseCase;
//        this.messageRemovableUseCase = messageRemovableUseCase;
    }

//    @PostMapping
//    public Mono<MessageEntity> create(@RequestBody MessageEntity messageEntity) {
//        return this.createMessageUseCase.execute(messageEntity);
//    }
//
//    @PutMapping("/{id}")
//    public Mono<MessageEntity> update(@PathVariable Long id, @RequestBody MessageEntity messageEntity) {
//        return this.updateByIdMessageUseCase.execute(id, messageEntity);
//    }

    @GetMapping
    public Flux<MessageEntity> getAll() {
        return this.getAllMessagesUseCase.execute();
    }

//    @GetMapping("/{id}")
//    public Mono<MessageEntity> getById(@PathVariable Long id) {
//        return this.getByIdMessageUseCase.execute(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<Void> deleteById(@PathVariable Long id) {
//        return this.messageRemovableUseCase.execute(id);
//    }
}
