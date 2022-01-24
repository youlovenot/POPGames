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

select * from member;

create table notice(
	seq int primary key,
    title varchar(20) not null,
    content varchar(1000) not null,
    regdate datetime default CURRENT_TIMESTAMP,
    cnt int default 0
	);
    
select * from notice;

insert into notice(seq, title, context)
values(0, '제목','내용');