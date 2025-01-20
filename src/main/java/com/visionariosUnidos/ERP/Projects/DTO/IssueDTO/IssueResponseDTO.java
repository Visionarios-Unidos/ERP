package com.visionariosUnidos.ERP.Projects.DTO.IssueDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssueResponseDTO {

    private Long id;
    private String name;
    private String description;
    private boolean closed;
    private LocalDateTime createdAt;
    private Long projectId;

}
