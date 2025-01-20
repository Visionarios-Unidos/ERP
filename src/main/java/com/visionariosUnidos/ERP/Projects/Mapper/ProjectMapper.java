package com.visionariosUnidos.ERP.Projects.Mapper;

import com.visionariosUnidos.ERP.Projects.DTO.ProjectDTO.ProjectRequestDTO;
import com.visionariosUnidos.ERP.Projects.DTO.ProjectDTO.ProjectResponseDTO;
import com.visionariosUnidos.ERP.Projects.Entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponseDTO toResponseDTO(Project project) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setId(project.getId());
        projectResponseDTO.setName(project.getName());
        projectResponseDTO.setDescription(project.getDescription());
        return projectResponseDTO;
    }

    public Project toEntity(ProjectRequestDTO projectRequestDTO) {
        Project project = new Project();
        project.setName(projectRequestDTO.getName());
        project.setDescription(projectRequestDTO.getDescription());
        return project;
    }

}
