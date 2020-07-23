1)---- Есть таблица встреч(id, name), есть таблица юзеров(id, name).

CREATE TABLE meeting (
id serial PRIMARY KEY,
name varchar(100));

CREATE TABLE users (
id serial PRIMARY KEY,
name varchar(100));

----- Нужно доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах. 
----- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.

ALTER TABLE users
ADD COLUMN meet_id int references meeting(id),
ADD COLUMN participation varchar(3);

2) --- Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.

SELECT m.name, count(u.name) FROM meeting AS m
FULL JOIN users as u
ON m.id = u.meet_id
and u.participation = 'yes'
group by(m.name)
order by (m.name);

3) ----- Нужно получить все совещания, где не было ни одной заявки на посещения

SELECT m.name FROM meeting AS m
Left OUTER JOIN users AS u
ON m.id = u.meet_id
WHERE u.name IS NULL;


 

 


