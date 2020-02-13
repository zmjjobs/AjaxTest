create table location (
location_id number(4) primary key,
street_address varchar2(40) not null,
postal_code varchar2(12),
city varchar2(30) not null,
state_province varchar2(25),
couniry_id char(2)
);