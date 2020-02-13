create table department (
department_id number(4) primary key,
department_name varchar2(30) not null,
manager_id number(6),
location_id number(4)
);