1)---- Есть таблица встреч(id, name), есть таблица юзеров(id, name).

CREATE TABLE meeting (
id serial PRIMARY KEY,
name varchar(100));

CREATE TABLE users (
id serial PRIMARY KEY,
name varchar(100));

----- Нужно доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах. 
----- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.

CREATE TABLE users_meeting (
user_id int references users(id),
meet_id int references meeting(id),
participation varchar(3),
primary key (user_id, meet_id));

2) --- Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.

SELECT array_to_string(array_agg(meeting.name), ',')  AS meet_name, count (users.name) AS cout_part
FROM meeting
LEFT OUTER JOIN users_meeting
ON meeting.id = users_meeting.meet_id
and users_meeting.participation = 'yes'
LEFT OUTER JOIN users
ON users.id = users_meeting.meet_id;

3) ----- Нужно получить все совещания, где не было ни одной заявки на посещения

SELECT m.name  FROM meeting AS m
LEFT OUTER JOIN users_meeting  AS u_m
ON m.id = u_m.meet_id
LEFT JOIN users AS u
ON u.id = u_m.meet_id
WHERE u.name IS NULL; 
 






 

 


