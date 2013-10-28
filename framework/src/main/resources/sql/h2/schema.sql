drop table if exists s_user;
create table s_user (
	id varchar(64) generated by default as identity,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	register_date timestamp not null,
	primary key (id)
);


drop table if exists s_role;
create table s_role(
   id varchar(64) generated by default as identity,
   name varchar(64) not null,
   roledesc varchar(255),
   primary key (id)
);