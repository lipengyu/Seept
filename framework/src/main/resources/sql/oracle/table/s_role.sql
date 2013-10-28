-- Create table
create table S_ROLE
(
  ID       VARCHAR2(64) not null,
  NAME     VARCHAR2(64),
  ROLEDESC VARCHAR2(255)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table S_ROLE
  add constraint PK_S_ROLE_ID primary key (ID)
  using index;
