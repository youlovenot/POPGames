create database POPGAMES;

use POPGAMES;

create table member(
	id varchar(20) primary key,
	password varchar(20) not null,
	name varchar(20) not null,
	phone varchar(20) not null,
	email varchar(20),
	nickname varchar(20),
	zipcode varchar(20),
	adress1 varchar(20),
	adress2 varchar(20)
    );