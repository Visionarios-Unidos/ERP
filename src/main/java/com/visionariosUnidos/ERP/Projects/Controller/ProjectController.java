package com.visionariosUnidos.ERP.Projects.Controller;

import com.visionariosUnidos.ERP.Projects.DTO.ProjectDTO.ProjectRequestDTO;
import com.visionariosUnidos.ERP.Projects.DTO.ProjectDTO.ProjectResponseDTO;
import com.visionariosUnidos.ERP.Projects.Entity.Project;
import com.visionariosUnidos.ERP.Projects.Mapper.ProjectMapper;
import com.visionariosUnidos.ERP.Projects.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;
    private ProjectMapper projectMapper;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        List<Project> projects = projectService.getProjects();
        List<ProjectResponseDTO> responseDTOs = projects.stream()
                .map(projectMapper::toResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(value -> new ResponseEntity<>(projectMapper.toResponseDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Return 404 if not found
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        Project project = projectMapper.toEntity(projectRequestDTO);
        Project savedProject = projectService.saveProject(project);
        ProjectResponseDTO responseDTO = projectMapper.toResponseDTO(savedProject);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDTO projectRequestDTO) {
        Optional<Project> existingProject = projectService.getProjectById(id);

        if (existingProject.isPresent()) {
            Project project = existingProject.get();
            if (projectRequestDTO.getName() != null) {
                project.setName(projectRequestDTO.getName());
            }
            if (projectRequestDTO.getDescription() != null) {
                project.setDescription(projectRequestDTO.getDescription());
            }
            Project updatedProject = projectService.saveProject(project);
            ProjectResponseDTO responseDTO = projectMapper.toResponseDTO(updatedProject);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
    }

}
