/*정상인 개발자라면 무조건 primary key
제약조건은 부여해야 한다!!*/
create table student3(
	student3_id number primary key
	,name varchar2(20) not null
	,email varchar2(30) unique
	,gender char(3) check(gender in ('남','여'))
);
insert into student3(student3_id,name,email,gender)
values(2,'김민정','swatmj@naver.com','여');
select * from student3;
/*테이블 중 중복되지 않는 숫자값을 
보유하고 있는 테이블을 가리켜 시퀀스
나 대신에 카운터 해준다 seq_대상테이블 로 주로 작성함
프라이머리 키와 함께 무조건 생성해야한다*/
create sequence seq_student3
start with 1 --1부터 시작해서..
increment by 1;
--1씩 증가시켜라
delete from student3;
commit;
--되돌릴 수 없다.
insert into student3(student3_id,name,email,gender)
values(seq_student3.nextval,'swatmj','dd','여');
select * from student3;
delete from student3 where student3_id=(
	select max(student3_id) from student3
);
--확정 짓기
commit;
/*제약조건이란? 무결성 확보를 위해 컬럼에 부여하는
	제약사항
(1) unique 
(2) not null
(3) primary key
(4) default 기본값 - 개발자가 넣지않아도 
		즉, insert 문에 명시하지 않아도 기본으로 들어갈 값
(5) foreign key
*/
create table test(
	name varchar(20) default '홍'
	,regdate date default sysdate
	,age number 
);
insert into test(age) values(20);
select * from test;
