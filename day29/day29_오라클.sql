--딕셔너리 (시스템 테이블)
--현재 사용중 계정인 일반유저(user_),
--관리자(dba_), v$
desc emp;
--해당 테이블의 구조를 알수 있는 명령어
--개발자가 딕셔너리의 테이블은 알수 있지만,
--딕셔너리가 보유한 테이블의 컬럼명은 알수없으므로
--콘솔창에 쳐보자
--내가 보유한 테이블 명단을 알수 있는 명령어는?
desc user_tables;
--여기서 찾은 두개
--테이블의 이름 ,테이블스페이스의 이름을 알아볼거야
--일반유저의 테이블에서
select table_name, tablespace_name
from user_tables;
