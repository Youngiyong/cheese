package com.cheese.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EAdminRolePrivilege {
    READ_PRIVILEGE,
    WRITE_PRIVILEGE,
    DELETE_PRIVILEGE
}
