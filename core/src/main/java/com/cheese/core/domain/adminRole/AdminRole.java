package com.cheese.core.domain.adminRole;


import com.cheese.core.domain.adminRolePrivilege.AdminRolePrivilege;
import com.cheese.core.domain.enums.EAdminRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(	name = "admin_roles")
public class AdminRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EAdminRole name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "admin_role_privileges_join",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<AdminRolePrivilege> adminRolePrivileges = new HashSet<>();
}
