create database POPGAMES;

use POPGAMES;

create table member(
	id varchar(20) primary key,
	password varchar(20) not null,
	name varchar(20) not null,
	phone varchar(20),
	email varchar(20),
	zipcode varchar(20),
	adress1 varchar(20),
	adress2 varchar(20)
    );

insert into member(id,password,name)
values("admin","admin1234","관리자");