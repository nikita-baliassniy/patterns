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