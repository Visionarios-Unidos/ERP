package com.visionariosUnidos.ERP.Comunications.controller;

import com.visionariosUnidos.ERP.Comunications.dto.CreateChatDto;
import com.visionariosUnidos.ERP.Comunications.service.IChatService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chat", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private IChatService chatService;

    @PostMapping("/create")
    public ResponseEntity<String> createChat( @Valid @RequestBody CreateChatDto createChatDto){

            chatService.createChat(createChatDto);
        return ResponseEntity.ok("All okay");
    }
}
