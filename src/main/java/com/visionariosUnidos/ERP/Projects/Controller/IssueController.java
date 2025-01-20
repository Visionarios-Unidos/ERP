package com.visionariosUnidos.ERP.Projects.Controller;

import com.visionariosUnidos.ERP.Projects.DTO.IssueDTO.IssueRequestDTO;
import com.visionariosUnidos.ERP.Projects.DTO.IssueDTO.IssueResponseDTO;
import com.visionariosUnidos.ERP.Projects.Entity.Issue;
import com.visionariosUnidos.ERP.Projects.Entity.Project;
import com.visionariosUnidos.ERP.Projects.Mapper.IssueMapper;
import com.visionariosUnidos.ERP.Projects.Service.IssueService;
import com.visionariosUnidos.ERP.Projects.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IssueMapper issueMapper;

    @GetMapping
    public List<IssueResponseDTO> getAllIssues() {
        List<Issue> issues = issueService.getIssues();
        return issues.stream()
                .map(issueMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public IssueResponseDTO getIssueById(@PathVariable Long id) {
        Optional<Issue> issue = issueService.getIssueById(id);
        return issue.map(issueMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
    }

    @PostMapping
    public IssueResponseDTO createIssue(@RequestBody IssueRequestDTO issueRequestDTO) {
        Project project = projectService.getProjectById(issueRequestDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Issue issue = issueMapper.toEntity(issueRequestDTO, project);
        Issue createdIssue = issueService.saveIssue(issue);
        return issueMapper.toResponseDTO(createdIssue);
    }


    @PatchMapping("/{id}")
    public IssueResponseDTO partialUpdateIssue(@PathVariable Long id, @RequestBody IssueRequestDTO issueRequestDTO) {
        Issue existingIssue = issueService.getIssueById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        if (issueRequestDTO.getName() != null) {
            existingIssue.setName(issueRequestDTO.getName());
        }
        if (issueRequestDTO.getDescription() != null) {
            existingIssue.setDescription(issueRequestDTO.getDescription());
        }
        if (issueRequestDTO.getClosed() != null) {
            existingIssue.setClosed(issueRequestDTO.getClosed());
        }
        if (issueRequestDTO.getProjectId() != null) {
            Project project = projectService.getProjectById(issueRequestDTO.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            existingIssue.setProject(project);
        }
        Issue updatedIssue = issueService.saveIssue(existingIssue);
        return issueMapper.toResponseDTO(updatedIssue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        boolean isDelete = issueService.deleteIssue(id);
        if (isDelete){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
