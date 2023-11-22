--liquibase formatter sql

--changelog koshechkin:1
ALTER TABLE task
ADD COLUMN status;