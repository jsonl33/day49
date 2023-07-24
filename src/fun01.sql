create table tbl_gu (
gno int primary key,
gname varchar2(20) not null,
gtitle varchar2(200) not null,
gcont varchar2(4000) not null,
gdate date default sysdate
);

create sequence gno_seq10 
INCREMENT by 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
NOCACHE;

commit;

insert into tbl_gu values(gno_seq10.nextval,?,?,?,sysdate);