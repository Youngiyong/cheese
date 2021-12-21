package com.cheese.admin.error;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ErrorCode {
    // TODO: Need to refine
    SUCCESS(200, "C000", "OK"),
    // Common
    INVALID_PARAMETER(400, "C004", "Invalid Request Data"),
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
    INVALID_TYPE_VALUE(400, "C001", "Invalid Input Type Value"),
    INTERNAL_SERVER_ERROR(500, "C001", "Internal Server Error"),
    // Member
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid");
//    ATTESTATION_CERTIFICATE_ERROR(1),
//    U2F_ATTESTATION_KEY_NOT_ECC_TYPE(2),
//    U2F_ATTESTATION_USER_KEY_INVALID(3),
//    U2F_ATTESTATION_AAGUID_INVALID(4),
//    SIGNATURE_VERIFICATION_ERROR(4),
//    PACKED_ATTESTATION_ALGORITHM_NOT_MATCHED(5),
//    USER_PUBLIC_KEY_INVALID_KEY_SPEC(6),
//
//    INVALID_ATTESTATION_FORMAT(52),
//    INVALID_AUTHENTICATOR_DATA(53),
//    CREDENTIAL_NOT_INCLUDED(54),
//    CREDENTIAL_NOT_FOUND(55),
//    ASSERTION_SIGNATURE_VERIFICATION_FAIL(56),
//
//    INVALID_ORIGIN(80),
//
//    INTERNAL_SERVER_ERROR(999);


    @Getter private final int status;
    @Getter private final String code;
    @Getter private final String message;


}
