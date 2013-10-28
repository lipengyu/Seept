
  drop table s_user;

  create table S_USER
  (
    ID            VARCHAR2(64) not null,
    LOGIN_NAME    VARCHAR2(64),
    NAME          VARCHAR2(64),
    PASSWORD      VARCHAR2(255),
    REGISTER_DATE DATE
  );
  alter table S_USER
    add constraint PK_SUSER_ID primary key (ID)
    using index;
