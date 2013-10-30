-- Create table
create table S_USER_ROLE
(
  ID     VARCHAR2(64) not null,
  USERID VARCHAR2(64),
  ROLEID VARCHAR2(64)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table S_USER_ROLE
  add constraint PK_S_USER_ROLE_ID primary key (ID)
  using index;
