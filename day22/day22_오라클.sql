-- 부서명, 사원명, 급여를 출력하시오.
-- 10번부서의..
-- n (4) * m (14) = 56 레코드
-- 양쪽테이블에 공통인 레코드만..
select dname,ename,sal 
from dept d,emp e
where d.deptno =e.deptno;

--부서이름별 소속된 사원수를 출력
select dname, count(*)
from dept d,emp e
where d.deptno =e.deptno
group by dname;

--그룹화 시키자
--그룹화는 컬럼명과 동일하게,
--예외는 집계함수는 이미 집계되어있는거니깐, 동일할 필요없이 적용가능

--부서테이블 조사해보자
select * from dept;

--한번도 써본적 없는 operation 이라는 부서가 나온다
--사원이 존재하지 않는 부서라서 나오지 않는다

--오늘 수업의 주제 : 조인할 때 where 조건만 있는게 아니다!!
--조인에 대해서 다시 한번 정리해보자

select *
from emp e,dept d
where e.deptno=d.deptno;

--이것은 inner 조인
--operation 부서처럼 공통되지 않은 것은 안가져온다

--이 때 공통되지 않은 것을 가져오기 위해 outer 조인을 쓴다
--select *
--from --무조건 가져올 테이블명 --먼저명시한 테이블 --left 라 한다, 거기에다가 가져올 테이블 join 한다 
--on --조건

select *
from dept d left outer join emp e
on d.deptno=e.deptno;

--각 부서별 사원수를 출력하시오.
select dname, count(empno)
from dept d left outer join emp e
on d.deptno=e.deptno
group by dname;

--group by에온 컬럼만이 , select 에 올수있다.
--(*)를 해버리면, 아래쪽 테이블이 나오니깐, 사원과 관련된 것을 넣어보자

--하위 카테고리 
--혼동하지 않기위해 , s. 이렇게 붙이는거다..
--중복되지 않는 컬럼이면 붙이지 않아도 된다
select s.subcategory_id , sub_name, count(product_name) as 총개수
from subcategory s left outer join product p
on s.SUBCATEGORY_ID = p.SUBCATEGORY_ID
group by s.subcategory_id , sub_name;

--가짜이름 = 알리야스 as 붙혀라

select * from PRODUCT
where subcategory_id=--유저가선택한id;