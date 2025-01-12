package com.visionariosUnidos.ERP.Comunications.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/chat", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchChat(){

        return ResponseEntity.ok("All okay");
    }
}
