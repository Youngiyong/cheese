package com.cheese.core.domain.userRoles;

import com.cheese.core.domain.adminRole.AdminRole;
import com.cheese.core.domain.adminRolePrivilege.AdminRolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(Enum name);
}
