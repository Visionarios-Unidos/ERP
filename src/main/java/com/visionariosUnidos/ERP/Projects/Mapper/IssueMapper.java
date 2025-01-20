package com.visionariosUnidos.ERP.Projects.Mapper;

import com.visionariosUnidos.ERP.Projects.DTO.IssueDTO.IssueRequestDTO;
import com.visionariosUnidos.ERP.Projects.DTO.IssueDTO.IssueResponseDTO;
import com.visionariosUnidos.ERP.Projects.Entity.Issue;
import com.visionariosUnidos.ERP.Projects.Entity.Project;
import org.springframework.stereotype.Component;

@Component
public class IssueMapper {

    public IssueResponseDTO toResponseDTO(Issue issue) {
        IssueResponseDTO issueResponseDTO = new IssueResponseDTO();
        issueResponseDTO.setId(issue.getId());
        issueResponseDTO.setName(issue.getName());
        issueResponseDTO.setDescription(issue.getDescription());
        issueResponseDTO.setClosed(issue.getClosed());
        issueResponseDTO.setCreatedAt(issue.getCreatedAt());
        issueResponseDTO.setProjectId(issue.getProject() != null ? issue.getProject().getId() : null);
        return issueResponseDTO;
    }

    public Issue toEntity(IssueRequestDTO issueRequestDTO, Project project) {
        Issue issue = new Issue();
        issue.setName(issueRequestDTO.getName());
        issue.setDescription(issueRequestDTO.getDescription());
        issue.setClosed(issueRequestDTO.getClosed());
        issue.setProject(project);
        return issue;
    }

}
