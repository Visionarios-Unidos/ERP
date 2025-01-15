package com.visionariosUnidos.ERP.Comunications.dto;

import com.visionariosUnidos.ERP.Comunications.constants.Visibility;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateChatDto {

    @NotNull(message = "Visibility cannot be null")
    private Visibility visibility;

    @Size(min = 1, message = "A chat must have at least one user")
    private List<Integer> userIds;

}