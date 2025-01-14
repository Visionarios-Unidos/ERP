package com.visionariosUnidos.ERP.Projects.Repository;

import com.visionariosUnidos.ERP.Projects.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
