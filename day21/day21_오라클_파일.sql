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
--데이터 넣자

--상위 
insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'케익');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'빵');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'제과');

insert into topcategory(topcategory_id,top_name)
values(seq_topcategory.nextval,'샐러드');

--하위

-----1-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'생크림','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'고구마','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'치즈','1');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'초코','1');

-----2-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'슈크림','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'피자빵','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'소보로','2');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'멜론빵','2');

-----3-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'초코쿠키','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'딸기쿠키','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'바닐라쿠키','3');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'양갱쿠키','3');

-----4-----
insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'치킨샐러드','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'시저샐러드','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'연어샐러드','4');

insert into subcategory(subcategory_id,sub_name,topcategory_id)
values(seq_subcategory.nextval,'리코타치즈샐러드','4');

commit;