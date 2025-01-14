package com.visionariosUnidos.ERP.Projects.Service;

import com.visionariosUnidos.ERP.Projects.Entity.Issue;
import com.visionariosUnidos.ERP.Projects.Repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IssueService {

    private IssueRepository issueRepository;

    public Optional<List<Issue>> getIssues() {
        return Optional.of(issueRepository.findAll());
    }

    public Optional<Issue> getIssueById(Long id) {
        return issueRepository.findById(id);
    }

    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}
