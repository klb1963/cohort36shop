package de.ait_tr.g_36_shop.repository;

import de.ait_tr.g_36_shop.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTitle(String title); // Optional - удобно, чтобы не получить null pointer exception
}
