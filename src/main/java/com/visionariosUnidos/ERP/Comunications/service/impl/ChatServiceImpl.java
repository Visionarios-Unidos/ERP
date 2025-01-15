package com.visionariosUnidos.ERP.Comunications.service.impl;

import com.visionariosUnidos.ERP.Auth.Service.CustomUserDetails;
import com.visionariosUnidos.ERP.Comunications.controller.ChatController;
import com.visionariosUnidos.ERP.Comunications.dto.CreateChatDto;
import com.visionariosUnidos.ERP.Comunications.repository.ChatRepository;
import com.visionariosUnidos.ERP.Comunications.service.IChatService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements IChatService {

    private ChatRepository chatRepository;
    private static final Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Override
    public void createChat(CreateChatDto createChatDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        log.info("username is " + customUserDetails.getUsername());

    }
}
