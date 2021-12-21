package com.cheese.admin.error;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum InternalErrorCode {
    // TODO: Need to refine
    SUCCESS(0),
    ATTESTATION_CERTIFICATE_ERROR(1),
    U2F_ATTESTATION_KEY_NOT_ECC_TYPE(2),
    U2F_ATTESTATION_USER_KEY_INVALID(3),
    U2F_ATTESTATION_AAGUID_INVALID(4),
    SIGNATURE_VERIFICATION_ERROR(4),
    PACKED_ATTESTATION_ALGORITHM_NOT_MATCHED(5),
    USER_PUBLIC_KEY_INVALID_KEY_SPEC(6),

    INVALID_ATTESTATION_FORMAT(52),
    INVALID_AUTHENTICATOR_DATA(53),
    CREDENTIAL_NOT_INCLUDED(54),
    CREDENTIAL_NOT_FOUND(55),
    ASSERTION_SIGNATURE_VERIFICATION_FAIL(56),

    INVALID_ORIGIN(80),

    INTERNAL_SERVER_ERROR(999);



    @Getter private final int code;

    public static InternalErrorCode fromCode(int code) {
        return Arrays
                .stream(InternalErrorCode.values()).filter(e -> e.code == code)
                .findFirst()
                .get();
    }
}
