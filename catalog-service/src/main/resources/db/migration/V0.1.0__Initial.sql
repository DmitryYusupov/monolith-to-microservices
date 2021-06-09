drop table if exists mark CASCADE;
drop table if exists model CASCADE;

create table mark (id UUID not null, name varchar(255), primary key (id));
create table model (id UUID not null, name varchar(255) not null, mark_id UUID, primary key (id));

alter table model add constraint FKtj5rabfi6sypr43683jbhs78g foreign key (mark_id) references mark;

insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d1', 'bmw');
insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d2', 'audi');
insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d3', 'mercedes-benz');

insert into model (id, name, mark_id) values ('a5f2274b-2ed7-45c4-8485-8c6f70f15b21', 'X3','e794d476-f333-461d-8ce0-79849bba89d1');
insert into model (id, name, mark_id) values ('a5f2274b-2ed7-45c4-8485-8c6f70f15b22', 'X4','e794d476-f333-461d-8ce0-79849bba89d1');
insert into model (id, name, mark_id) values ('a5f2274b-2ed7-45c4-8485-8c6f70f15b23', 'X5','e794d476-f333-461d-8ce0-79849bba89d1');

insert into model (id, name, mark_id) values ('95511d24-5c62-481e-a37d-1ee82ebd3a01', 'A6','e794d476-f333-461d-8ce0-79849bba89d2');
insert into model (id, name, mark_id) values ('95511d24-5c62-481e-a37d-1ee82ebd3a02', 'A7','e794d476-f333-461d-8ce0-79849bba89d2');
insert into model (id, name, mark_id) values ('95511d24-5c62-481e-a37d-1ee82ebd3a03', 'A8','e794d476-f333-461d-8ce0-79849bba89d2');

insert into model (id, name, mark_id) values ('eb179524-9644-433b-aa0c-6fc7ec1935d1', 'C','e794d476-f333-461d-8ce0-79849bba89d3');
insert into model (id, name, mark_id) values ('eb179524-9644-433b-aa0c-6fc7ec1935d2', 'E','e794d476-f333-461d-8ce0-79849bba89d3');
insert into model (id, name, mark_id) values ('eb179524-9644-433b-aa0c-6fc7ec1935d3', 'S','e794d476-f333-461d-8ce0-79849bba89d3');