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
    id         INT  not null
        primary key AUTO_INCREMENT,
    role_id int not null,
    privilege_id int not null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


create table admin_role_join
(
    id         INT  not null
        primary key AUTO_INCREMENT,
    admin_id int not null,
    role_id int not null
) ENGINE = InnoDb DEFAULT CHARSET=utf8;


INSERT INTO admin (id, username, email, password) VALUES (1, 'test1', 'test1@test.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');
INSERT INTO admin (id, username, email, password) VALUES (2, 'test2', 'test2@test.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');
INSERT INTO admin (id, username, email, password) VALUES (3, 'admin', 'admin@example.com', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC');

INSERT INTO admin_roles(id, name, description) VALUES (1, 'ROLE_ADMIN', '시스템관리자');
INSERT INTO admin_roles(id, name, description) VALUES (2, 'ROLE_MANAGER', '중간관리자');
INSERT INTO admin_roles(id, name, description) VALUES (3, 'ROLE_USER', '일반관리자(읽기)');

INSERT INTO admin_role_join (admin_id, role_id) VALUES (1, 2);
INSERT INTO admin_role_join (admin_id, role_id) VALUES (2, 3);
INSERT INTO admin_role_join (admin_id, role_id) VALUES (3, 1);

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

INSERT INTO admin_role_privilege_join (role_id, privilege_id) VALUES (2, 1);
INSERT INTO admin_role_privilege_join (role_id, privilege_id) VALUES (2, 6);

INSERT INTO admin_role_privilege_join (role_id, privilege_id) VALUES (3, 2);
INSERT INTO admin_role_privilege_join (role_id, privilege_id) VALUES (3, 7);

-- INSERT INTO admin_role_privileges VALUES (3, 'RESERVE_PRIVILEGE'); -- 적립금 관리 권한
-- INSERT INTO admin_role_privileges VALUES (4, 'DEPOSIT_PRIVILEGE'); -- 예치금 관리 권한
-- INSERT INTO admin_role_privileges VALUES (5, 'PAYMENT_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (5, 'PAYMENT_DETAIL_PRIVILEGE'); -- 결제 관리 상세 정보 보기 권한
--
-- INSERT INTO admin_role_privileges VALUES (6, 'SETTLE_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (7, 'MARKETING_PRIVILEGE'); -- 결제 관리 권한
-- INSERT INTO admin_role_privileges VALUES (8, 'OPERATION_PRIVILEGE'); -- 운영 관리 권한
-- INSERT INTO admin_role_privileges VALUES (9, 'DASHBOARD_PRIVILEGE'); -- 결제 관리 권한


CREATE TABLE oauth_client_details (
                                      client_id VARCHAR(256) PRIMARY KEY,
                                      resource_ids VARCHAR(256),
                                      client_secret VARCHAR(256),
                                      scope VARCHAR(256),
                                      authorized_grant_types VARCHAR(256),
                                      web_server_redirect_uri VARCHAR(256),
                                      authorities VARCHAR(256),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information VARCHAR(4096),
                                      autoapprove VARCHAR(256)
)
    ENGINE = InnoDb DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    enabled TINYINT(1),
    UNIQUE KEY unique_username(username)
    )
    ENGINE = InnoDb DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(256) NOT NULL,
    authority VARCHAR(256) NOT NULL,
    PRIMARY KEY(username, authority)
    )
    ENGINE = InnoDb DEFAULT CHARSET=utf8;

INSERT INTO oauth_client_details
   (client_id, client_secret, scope, authorized_grant_types,
   web_server_redirect_uri, authorities, access_token_validity,
   refresh_token_validity, additional_information, autoapprove)
VALUES ('testclient', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC', 'all', 'password,refresh_token', null, null, 36000, 36000, null, true);

INSERT INTO users (id, username, password, enabled) VALUES (1, 'test_user', '$2a$10$3MUolsky4nfLXHOgP3EHS.zRN4OM/hbgvnihP.VJdnwpdBqpbv3mC', 1);

INSERT INTO authorities (username, authority) VALUES ('test_user', 'ADMIN');


CREATE TABLE `cheese`.`terms` (
                                  `id` INT NOT NULL AUTO_INCREMENT,
                                  `description` TEXT NOT NULL,
                                  `is_essential` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '필수/선택 여부(1: 필수, 0: 선택)',
                                  `is_active` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '사용 여부(1: 활성, 0: 비활성)',
                                  `type` TINYINT(10) NOT NULL DEFAULT 1 COMMENT '타입 (1: 회원가입, 2: 질병청, 3: 추가 타입..)',
                                  `sort` TINYINT(100) NOT NULL DEFAULT 100 COMMENT '조회 순서',
                                  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `updated_at` TIMESTAMP NULL,
                                  `deleted_at` TIMESTAMP NULL,
                                  PRIMARY KEY (`id`))
ENGINE = InnoDb DEFAULT CHARSET=utf8;

CREATE TABLE `cheese`.`term_logs` (
                                      `id` BIGINT NOT NULL AUTO_INCREMENT,
                                      `user_id` INT NOT NULL COMMENT '유저 아이디\n',
                                      `term_id` INT NOT NULL COMMENT '약관 id',
                                      `is_agree` VARCHAR(45) NOT NULL DEFAULT '1' COMMENT '동의 여부',
                                      `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일자',
                                      PRIMARY KEY (`id`))
ENGINE = InnoDb DEFAULT CHARSET=utf8;

# CREATE TABLE `cheese`.`users` (
#                                   `id` INT NOT NULL AUTO_INCREMENT,
#                                   `name` VARCHAR(30) NOT NULL COMMENT '유저 이름',
#                                   `cp` VARCHAR(20) NOT NULL COMMENT '휴대폰번호',
#                                   `sex` VARCHAR(45) NULL COMMENT '성별',
#                                   `birth_year` VARCHAR(4) NULL COMMENT '년',
#                                   `birth_month` VARCHAR(2) NULL COMMENT '월',
#                                   `birth_day` VARCHAR(2) NULL COMMENT '일',
#                                   `is_active` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '활성 여부 (1: 활성, 0: 비활성)',
#                                   `is_account` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '계좌 활성 여부 (1: 활성, 0: 비활성)',
#                                   `is_qr` TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'QR 활성 여부 (1: 활성, 0: 비활성)',
#                                   `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일자',
#                                   `updated_at` TIMESTAMP NULL COMMENT '업데이트 일자',
#                                   `deleted_at` TIMESTAMP NULL COMMENT '탈퇴 일자',
#                                   `last_login` TIMESTAMP NULL COMMENT '마지막 로그인일자 (특정 기간이 지나면 비활성 계정으로 전환을 위해 생성)\\n',
#                                   PRIMARY KEY (`id`))
#     ENGINE = InnoDb DEFAULT CHARSET=utf8;
#
#
# CREATE TABLE `cheese`.`user_roles` (
#                                   `id` INT NOT NULL AUTO_INCREMENT,
#                                   `name` VARCHAR(30) NOT NULL unique  COMMENT '권한명',
#                                   `description` VARCHAR(100) NOT NULL COMMENT '권한 설명',
#                                   PRIMARY KEY (`id`))
#     ENGINE = InnoDb DEFAULT CHARSET=utf8;


# create table user_role_join
# (
#     id         INT  not null
#         primary key AUTO_INCREMENT,
#     user_id int not null,
#     role_id int not null
# ) ENGINE = InnoDb DEFAULT CHARSET=utf8;