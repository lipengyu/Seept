prompt Importing table S_USER...
set feedback off
set define off
insert into S_USER (ID, LOGIN_NAME, NAME, PASSWORD, SALT, REGISTER_DATE)
values ('U001', 'admin', 'Admin', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', null);

insert into S_USER (ID, LOGIN_NAME, NAME, PASSWORD, SALT, REGISTER_DATE)
values ('U002', 'user', 'Calvin', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', null);

prompt Done.
