package com.visionariosUnidos.ERP.Projects.DTO.IssueDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IssueRequestDTO {

    private String name;
    private String description;
    private Boolean closed;
    private Long projectId;

}
