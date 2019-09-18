package com.github.cosmicdisorder.antefare.models.data;

import com.github.cosmicdisorder.antefare.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}