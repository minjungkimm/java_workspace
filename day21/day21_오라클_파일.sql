create sequence seq_product
increment by 1
start with 1;

create sequence seq_topcategory
increment by 1
start with 1;

create sequence seq_subcategory
increment by 1
start with 1;


----------------------------------------------------------------
--������ ����

--���� 
insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'����');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'��');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'����');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'������');

--����

-----1-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'��ũ��','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'����','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'ġ��','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'����','1');

-----2-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'��ũ��','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'���ڻ�','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'�Һ���','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'��л�','2');

-----3-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'������Ű','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'������Ű','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'�ٴҶ���Ű','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'�簻��Ű','3');

-----4-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'ġŲ������','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'����������','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'���������','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'����Ÿġ�������','4');

commit;