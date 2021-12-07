INSERT INTO
    oauth_client_details (
    client_id,
    client_secret,
    resource_ids,
    scope,
    authorized_grant_types,
    authorities,
    access_token_validity,
    refresh_token_validity
)
VALUES
    (
        'client',
        '$2a$10$4R/rWflN2RDiGZ3TvGplN.Z7fpILYAop9kJKqk7FgZnHCGhwFSGYS'
        'oauth2-resource',
        'read,write',
        'authorization_code,check_token,refresh_token,password',
        'ROLE_CLIENT',
        30,
        21600
    );


-- password 1234
INSERT INTO users (id, email, password, role) VALUES (1, 'test@test.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC', 'ROLE_USER');