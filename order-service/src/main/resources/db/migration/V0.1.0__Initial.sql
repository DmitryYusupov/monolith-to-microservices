drop table if exists orders CASCADE;
create table orders (id UUID not null, created_at timestamp, description varchar(255), finished boolean, price integer, priority integer, model_id UUID not null, user_id UUID not null, primary key (id));
