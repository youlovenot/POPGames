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
	adress2 varchar(20),
    role varchar(20) not null
    );

insert into member(id, password, name, role)
values('admin','admin1234', '관리자', 'Admin');
insert into member
values('youlovenot','Pa$$w0rd', '이상훈','010-1111-1111', 'youlovenot@naver.com','123-456','메롱시티','파인에플집' ,'User'); 

select * from member;

create table notice(
	seq int primary key,
    title varchar(20) not null,
    content varchar(1000) not null,
    regdate datetime default CURRENT_TIMESTAMP,
    cnt int default 0
	);
    
select * from notice order by seq desc;

delete from notice where seq=20;

insert into notice(seq, title, content)
values(1, '제목1','내용1');

