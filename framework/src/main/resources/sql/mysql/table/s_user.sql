CREATE TABLE s_user (
  id varchar(64) NOT NULL,
  name varchar(64) DEFAULT NULL,
  login_name varchar(64) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  salt varchar(64) DEFAULT NULL,
  register_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB