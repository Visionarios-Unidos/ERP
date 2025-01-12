package com.visionariosUnidos.ERP.Auth.Repository;

import com.visionariosUnidos.ERP.Auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
