create TABLE IF NOT EXISTS "user" (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age  int NOT NULL,
    email varchar(50) not null
);

insert into "user" (name, age, email) values ('Ivan', 26, 'ivan1@yandex.ru');
insert into "user" (name, age, email) values ('Petr', 28, 'petr2@yandex.ru');
insert into "user" (name, age, email) values ('Sidor', 22, 'sidor3@yandex.ru');