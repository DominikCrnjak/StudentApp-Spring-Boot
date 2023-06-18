delete from student;

insert into student (id,first_name, last_name, jmbag, ects_points, date_of_birth)
values (1,'Ivo', 'Ivić', '0246053232', 120, NOW());
insert into student (id,first_name, last_name, jmbag, ects_points, date_of_birth)
values (2,'Pero', 'Perić', '0246053435', 50, NOW());
insert into student (id,first_name, last_name, jmbag, ects_points, date_of_birth)
values (3,'Jozo', 'Jozić', '0246053995', 20, NOW());

insert into course (id, name, ects_points)
values (1, 'Web aplikacije u Javi', 6);
insert into course (id, name, ects_points)
values (2, 'Programiranje u jeziku Java', 5);
insert into course (id, name, ects_points)
values (3, 'Matematika', 7);

insert into student_course (id, student_id, course_id)
values (1, 1, 1);
insert into student_course (id, student_id, course_id)
values (2, 2, 1);
insert into student_course (id, student_id, course_id)
values (3, 2, 2);
insert into student_course (id, student_id, course_id)
values (4, 3, 2);
insert into student_course (id, student_id, course_id)
values (5, 3, 3);

insert into login_user (id, username, password, first_name, last_name)
values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin'); -- password je 'test'
insert into login_user (id, username, password, first_name, last_name)
values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user'); -- password je 'test'
insert into authority (id, name)
values (1, 'ROLE_ADMIN');
insert into authority (id, name)
values (2, 'ROLE_USER');
insert into user_authority (user_id, authority_id)
values (1, 1);
insert into user_authority (user_id, authority_id)
values (2, 2);
