-- �μ���, �����, �޿��� ����Ͻÿ�.
-- 10���μ���..
-- n (4) * m (14) = 56 ���ڵ�
-- �������̺� ������ ���ڵ常..
select dname,ename,sal 
from dept d,emp e
where d.deptno =e.deptno;

--�μ��̸��� �Ҽӵ� ������� ���
select dname, count(*)
from dept d,emp e
where d.deptno =e.deptno
group by dname;

--�׷�ȭ ��Ű��
--�׷�ȭ�� �÷���� �����ϰ�,
--���ܴ� �����Լ��� �̹� ����Ǿ��ִ°Ŵϱ�, ������ �ʿ���� ���밡��

--�μ����̺� �����غ���
select * from dept;

--�ѹ��� �ẻ�� ���� operation �̶�� �μ��� ���´�
--����� �������� �ʴ� �μ��� ������ �ʴ´�

--���� ������ ���� : ������ �� where ���Ǹ� �ִ°� �ƴϴ�!!
--���ο� ���ؼ� �ٽ� �ѹ� �����غ���

select *
from emp e,dept d
where e.deptno=d.deptno;

--�̰��� inner ����
--operation �μ�ó�� ������� ���� ���� �Ȱ����´�

--�� �� ������� ���� ���� �������� ���� outer ������ ����
--select *
--from --������ ������ ���̺�� --��������� ���̺� --left �� �Ѵ�, �ű⿡�ٰ� ������ ���̺� join �Ѵ� 
--on --����

select *
from dept d left outer join emp e
on d.deptno=e.deptno;

--�� �μ��� ������� ����Ͻÿ�.
select dname, count(empno)
from dept d left outer join emp e
on d.deptno=e.deptno
group by dname;

--group by���� �÷����� , select �� �ü��ִ�.
--(*)�� �ع�����, �Ʒ��� ���̺��� �����ϱ�, ����� ���õ� ���� �־��

--���� ī�װ� 
--ȥ������ �ʱ����� , s. �̷��� ���̴°Ŵ�..
--�ߺ����� �ʴ� �÷��̸� ������ �ʾƵ� �ȴ�
select s.subcategory_id , sub_name, count(product_name) as �Ѱ���
from subcategory s left outer join product p
on s.SUBCATEGORY_ID = p.SUBCATEGORY_ID
group by s.subcategory_id , sub_name;

--��¥�̸� = �˸��߽� as ������

select * from PRODUCT
where subcategory_id=--������������id;