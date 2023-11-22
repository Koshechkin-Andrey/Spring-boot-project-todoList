--liquibase formatted sql

--changeset koshechkin:1
ALTER TABLE task
ADD COLUMN users_id BIGINT REFERENCES task(id)