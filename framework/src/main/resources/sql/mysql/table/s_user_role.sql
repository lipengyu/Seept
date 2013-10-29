CREATE TABLE s_user_role (
  id varchar(64) NOT NULL,
  userid varchar(64) DEFAULT NULL,
  roleid varchar(64) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB