drop table if exists user CASCADE;
create table user (id UUID not null, driver_license varchar(255), last_name varchar(255), name varchar(255), registered_at timestamp, primary key (id));

insert into user (id, driver_license, last_name, name, registered_at) values (
'beb92070-3181-491f-8cd7-132bcd43671e',
'driver123',
'Ivanov',
'Ivan',
CURRENT_TIMESTAMP()
);