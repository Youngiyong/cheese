package com.cheese.core.domain.adminRolePrivilege;

import com.cheese.core.domain.enums.EAdminRolePrivilege;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(	name = "admin_role_privileges")
public class AdminRolePrivilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EAdminRolePrivilege name;

}
