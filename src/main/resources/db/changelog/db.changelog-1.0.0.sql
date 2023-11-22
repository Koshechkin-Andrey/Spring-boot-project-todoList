--liquibase formatted sql

--changeset koshechkin:1
CREATE TABLE IF NOT EXISTS users
(
    id    BIGSERIAL PRIMARY KEY,
    email VARCHAR(64) NOT NULL UNIQUE
);


--changeset koshechkin:2
CREATE TABLE IF NOT EXISTS task
(
    id               BIGSERIAL PRIMARY KEY,
    description      JSONB     NOT NULL,
    date_of_creation TIMESTAMP NOT NULL,
    create_at        TIMESTAMP,
    modified_at      TIMESTAMP,
    create_by        VARCHAR(32),
    modified_by      VARCHAR(32)
)
