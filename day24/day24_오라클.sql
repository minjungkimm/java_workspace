select * from score;

select count(gender) as �����ڼ�, gender as ����, (select count(*) from score) as ���л� 
, (count(gender)/(select count(*) from score))*100 as ����
from score
group by gender;

select count(*) , grade as �����ڼ�
, (count(grade)/(select count(grade) from score))*100 as ����
from score
group by grade;