select * from score;

select count(gender) as 응시자수, gender as 성별, (select count(*) from score) as 총학생 
, (count(gender)/(select count(*) from score))*100 as 비율
from score
group by gender;

select count(*) , grade as 응시자수
, (select count(*) from score) as 총학생수
, (count(grade)/(select count(grade) from score))*100 as 비율
from score
group by grade;