BEGIN;
SET search_path TO hiber,public;

CREATE TABLE teachers (
    id                      bigserial PRIMARY KEY,
    fullname                varchar(255),
    experience              int,
    age                     int,
    salary                  numeric(10, 2),
    specialisation          varchar(255)
);

CREATE TABLE clients (
    id                      bigserial PRIMARY KEY,
    fullname                varchar(255),
    age                     int,
    gradation               int,
    static_discount         numeric(4, 2)
);

CREATE TABLE lessons (
    id                      bigserial PRIMARY KEY,
    specialisation          varchar(255),
    duration                int,
    topic                   varchar(255),
    teacher_id                 bigint references teachers (id),
    client_id                  bigint references clients (id)
);

insert into teachers (fullname, experience, age, salary, specialisation)
values
('Petrov Petr Petrovich', 15, 45, 100000.00, 'History'),
('Ivanov Ivan Ivanovich', 10, 36, 80000.00, 'Math');

insert into clients (fullname, age, gradation, static_discount)
values
('Pupkin Semen Gennadievich', 16, 2, 0.00),
('Yagodkin Ilya Vasilievich', 14, 1, 0.50);

insert into lessons (specialisation, duration, topic, teacher_id, client_id)
values
('History', 45, 'Stone age', 1, 1),
('Math', 90, 'Integrals', 2, 1),
('Math', 90, 'Circles', 2, 2);

COMMIT;