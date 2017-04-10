
insert into student2(name,gender)
values('이긍열' ,'남');


alter table student2 
add student_id number;

--테이블 없애자
drop table student2;

--테이블을 제대로 만들자
--적어도 중복되지 않게할 컬럼은
--무조건 추가해야 한다!!
--결국, 테이블 생성시 조건을 부여해야 한다
--컬럼에 가하는 이러한 제한 or 조건을 가리켜
--제약조건이라 한다..
drop table student2;

create table student2(
	st_id number unique not null
	,name varchar(20)
	,gender char(3)
);


insert into student2(st_id,name,gender)
values(1,'이긍열' ,'남');

insert into student2(name,gender)
values('이긍열' ,'남');

--unique는 null을 허용한다는 허점이 있다
--unique 제약조건과 not null제약조건을 
--합쳐놓은 제약조건을 primary key
--테이블 생성시 primary key 무조건!!


