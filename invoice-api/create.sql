create table invoice (id int8 generated by default as identity, company_name varchar(255), due_date date, status varchar(255), value numeric(19, 2), user_id int8, primary key (id));
create table tb_user (id int8 generated by default as identity, cpf varchar(255), date_of_birth date, first_name varchar(255), last_name varchar(255), primary key (id));
alter table if exists tb_user add constraint UK_869sa3rebuf3nm0d4jwxdtouk unique (cpf);
alter table if exists invoice add constraint FKh3coyxgwtclayqg3hxyexgpgy foreign key (user_id) references tb_user;
