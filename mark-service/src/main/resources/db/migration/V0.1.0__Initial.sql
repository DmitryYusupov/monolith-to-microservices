drop table if exists mark CASCADE;
create table mark (id UUID not null, name varchar(255), primary key (id));

insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d1', 'bmw');
insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d2', 'audi');
insert into mark (id, name) values ('e794d476-f333-461d-8ce0-79849bba89d3', 'mercedes-benz');