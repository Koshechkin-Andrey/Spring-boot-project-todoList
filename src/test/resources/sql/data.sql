INSERT INTO users (id, email)
VALUES (1, 'alex@gmail.com'),
       (2, 'bob@gmail.com'),
       (3, 'anna@gmail.com');
SELECT setval("users_id_seq", (SELECT MAX(id) FROM users));


INSERT INTO task(id, description, date_of_creation, user_id, status)
VALUES (1, '{"description":"Нужно изучить spring-boot"}', '2023.10.21', 1, 'IN_PROGRESS'),
       (2, '{"description":"Нужно изучить java core"}', '2023.09.01', 1, 'COMPLETED'),
       (3, '{"description":"Нужно найти работу java developer"}', '2023.10.11', 1, 'IN_PROGRESS'),

       (4, '{"description":"Нужно Пойти в спортзал"}', '2024.12.01', 2, 'IN_PROGRESS'),

       (5, '{"description":"Нужно написать свой пет-проект"}', '2023.11.21', 3, 'IN_PROGRESS'),
       (6, '{"description":"Нужно купить машину"}', '2023.10.19', 3, 'COMPLETED');

SELECT setval("task_id_seq", (SELECT MAX(id) FROM task));
