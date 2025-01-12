package com.visionariosUnidos.ERP.Auth.Repository;

import com.visionariosUnidos.ERP.Auth.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
