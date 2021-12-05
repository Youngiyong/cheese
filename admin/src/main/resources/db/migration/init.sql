create table admin
(
    id         INT  not null
        primary key AUTO_INCREMENT,
    username       varchar(100) not null unique ,
    email      varchar(50) not null unique,
    password VARCHAR(255) NOT NULL,
    is_active TINYINT DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,
    deleted_at TIMESTAMP NULL
) ENGINE = InnoDb DEFAULT CHARSET=utf8;

create table admin_roles
(
    id         INT  not null
        primary key AUTO_INCREMENT,
    name       varchar(100) not null unique,
    description     varchar(50) null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


create table admin_role_privileges
(
    id         INT  not null
        primary key AUTO_INCREMENT,
    name       varchar(100) not null unique,
    description     varchar(50) null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


create table admin_role_privilege_join
(
    role_id int not null,
    privilege_id int not null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


create table admin_role_join
(
    admin_id int not null,
    role_id int not null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


INSERT INTO admin (id, username, email, password) VALUES (1, 'test1', 'test1@test.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');
INSERT INTO admin (id, username, email, password) VALUES (2, 'test2', 'test2@test.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');
INSERT INTO admin (id, username, email, password) VALUES (3, 'admin', 'admin@example.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');

INSERT INTO admin_roles(id, name, description) VALUES (1, 'ROLE_ADMIN', '시스템관리자');
INSERT INTO admin_roles(id, name, description) VALUES (2, 'ROLE_MANAGER', '중간관리자');
INSERT INTO admin_roles(id, name, description) VALUES (3, 'ROLE_USER', '일반관리자(읽기)');

INSERT INTO admin_role_join VALUES (1, 2);
INSERT INTO admin_role_join VALUES (2, 3);
INSERT INTO admin_role_join VALUES (3, 1);

INSERT INTO admin_role_privileges(id, name) VALUES (1, 'STORE_PRIVILEGE'); -- 가맹점 관리 권한
INSERT INTO admin_role_privileges(id, name) VALUES (2, 'STORE_READ_PRIVILEGE'); -- 가맹점 관리 리스트 권한
INSERT INTO admin_role_privileges(id, name) VALUES (3, 'STORE_DETAIL_PRIVILEGE'); -- 가맹점 관리 상세 권한
INSERT INTO admin_role_privileges(id, name) VALUES (4, 'STORE_DELETE_PRIVILEGE'); -- 가맹점 관리 삭제 권한
INSERT INTO admin_role_privileges(id, name) VALUES (5, 'STORE_WRITE_PRIVILEGE'); -- 가맹점 관리 추가 권한

INSERT INTO admin_role_privileges(id, name) VALUES (6, 'USER_PRIVILEGE'); -- 사용자 관리 권한
INSERT INTO admin_role_privileges(id, name) VALUES (7, 'USER_READ_PRIVILEGE'); -- 사용자 관리 리스트 권한
INSERT INTO admin_role_privileges(id, name) VALUES (8, 'USER_DETAIL_PRIVILEGE'); -- 사용자 관리 상세 권한
INSERT INTO admin_role_privileges(id, name) VALUES (9, 'USER_DELETE_PRIVILEGE'); -- 사용자 관리 삭제 권한
INSERT INTO admin_role_privileges(id, name) VALUES (10, 'USER_WRITE_PRIVILEGE'); -- 사용자 관리 추가 권한

INSERT INTO admin_role_privilege_join VALUES (2, 1);
INSERT INTO admin_role_privilege_join VALUES (2, 6);

INSERT INTO admin_role_privilege_join VALUES (3, 2);
INSERT INTO admin_role_privilege_join VALUES (3, 7);

-- INSERT INTO admin_role_privileges VALUES (3, 'RESERVE_PRIVILEGE'); -- 적립금 관리 권한
-- INSERT INTO admin_role_privileges VALUES (4, 'DEPOSIT_PRIVILEGE'); -- 예치금 관리 권한
-- INSERT INTO admin_role_privileges VALUES (5, 'PAYMENT_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (5, 'PAYMENT_DETAIL_PRIVILEGE'); -- 결제 관리 상세 정보 보기 권한
--
-- INSERT INTO admin_role_privileges VALUES (6, 'SETTLE_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (7, 'MARKETING_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (8, 'OPERATION_PRIVILEGE'); -- 운영 관리 권한
-- INSERT INTO admin_role_privileges VALUES (9, 'DASHBOARD_PRIVILEGE'); -- 결제 관리 권한


