show tables;


create table customerInfo(
	mid varchar(20) not null primary key,
	pwd varchar(20) not null,
	name varchar(20) not null,
	socialNum varchar(20) not null,
	phoneNum varchar(20) not null,
	gender varchar(4) default '남자',
	birthDate date
);

desc customerInfo

drop table customerInfo;

insert into customerInfo values('hong1234', 'hh123456', '홍길동', '990101-4874561','010-1234-5678', default, date_format('10-03-11', '%y-%m-%d'));

select * from customerInfo;

create table movie(
	title varchar(20) not null,
	titlePoster varchar(100) not null
);

insert into movie values ('파묘', '/movieReservation/images/movie1.png');
insert into movie values ('댓글부대', '/movieReservation/images/movie2.png');
insert into movie values ('쿵푸팬더4', '/movieReservation/images/movie3.png');
insert into movie values ('인사이드아웃2', '/movieReservation/images/movie4.png');

select * from movie