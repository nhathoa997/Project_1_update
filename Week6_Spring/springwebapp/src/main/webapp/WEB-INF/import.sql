create table if not exists employee(
    id serial primary key,
    email varchar(40) not null unique,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    password char(40) not null,
    dept varchar(10) not null
);

create table if not exists department (
    id serial primary key,
    name varchar(10) not null unique
);

create table if not exists role (
  id serial primary key,
  name varchar(10) not null unique
);

create table if not exists employee_role(
    emp_id int references employee(id),
    role_id int references role(id),
    primary key (emp_id, role_id)
);