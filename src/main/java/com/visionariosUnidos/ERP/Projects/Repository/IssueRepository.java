package com.visionariosUnidos.ERP.Projects.Repository;

import com.visionariosUnidos.ERP.Projects.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
