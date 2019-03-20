/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/20 22:29:29                           */
/*==============================================================*/


drop trigger SYS_LOG_TRIGGER;

drop table if exists SYS_LOG;

/*==============================================================*/
/* Table: SYS_LOG                                               */
/*==============================================================*/
create table SYS_LOG
(
   ID                   numeric(20,0) not null,
   USER_ID              numeric(20,0) not null,
   USERNAME             varchar(50) not null,
   OPERATION            varchar(50),
   TIME                 numeric(11,0),
   METHOD               varchar(200),
   PARAMS               varchar(3000),
   IP                   varchar(64),
   GMT_CREATE           datetime,
   primary key (ID)
);


create or replace trigger SYS_LOG_TRIGGER
 before insert on SYS_LOG
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_log_sequence.NEXTVAL
     INTO :NEW.id
     FROM DUAL;
END;

CREATE TABLE sys_menu (
  menu_id number(20) NOT NULL ,
  parent_id number(20) ,
  name varchar2(50) ,
  url varchar2(200) ,
  perms varchar2(500),
  type number(20),
  icon varchar2(50),
  order_num number(11) ,
  gmt_create date ,
  gmt_modified date ,
  constraint PK_sys_menu primary key(menu_id));

  create  sequence sys_sys_menu

  minvalue  1

  maxvalue  999999999999999999999999999

  start  with  100

  increment  by  1

  cache  20;
      CREATE OR REPLACE TRIGGER sys_menu_trigger
 BEFORE
  INSERT
 ON sys_menu
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_sys_menu.NEXTVAL
     INTO :NEW.menu_id
     FROM DUAL;
END;

CREATE TABLE sys_role (
  role_id number(20) NOT NULL ,
  role_name varchar2(100) ,
  role_sign varchar2(100) ,
  remark varchar2(100) ,
  user_id_create number(20) ,
  gmt_create date ,
  gmt_modified date ,
  constraint PK_sys_role primary key(role_id));

create sequence sys_sys_role

  minvalue  1

  maxvalue  999999999999999999999999999

  start  with  100

  increment  by  100

  cache  20;
  
        CREATE OR REPLACE TRIGGER sys_role_trigger
 BEFORE
  INSERT
 ON sys_role
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_sys_role.NEXTVAL
     INTO :NEW.role_id
     FROM DUAL;
END;
  
CREATE TABLE sys_role_menu (
  id number(20) NOT NULL ,
  role_id number(20),
  menu_id number(20),
  constraint PK_sys_role_menu primary key(id));
  
create sequence sys_sys_role_menu

  minvalue  1

  maxvalue  999999999999999999999999999

  start  with  2000

  increment  by  1

  cache  20;
  
          CREATE OR REPLACE TRIGGER sys_role_menu_trigger
 BEFORE
  INSERT
 ON sys_role_menu
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_sys_role_menu.NEXTVAL
     INTO :NEW.id
     FROM DUAL;
END;

CREATE TABLE sys_user (
  user_id number(20) NOT NULL,
  username varchar2(50) ,
  password varchar2(50) ,
  email varchar2(100) ,
  mobile varchar2(100) ,
  status number(1) ,
  user_id_create number(20) ,
  gmt_create date ,
  gmt_modified date ,
  name varchar2(100),
  constraint PK_sys_user primary key(user_id));

create sequence sys_sys_user

  minvalue  1

  maxvalue  999999999999999999999999999

  start  with  3

  increment  by  1

  cache  20;
          CREATE OR REPLACE TRIGGER sys_user_trigger
 BEFORE
  INSERT
 ON sys_user
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_sys_user.NEXTVAL
     INTO :NEW.user_id
     FROM DUAL;
END;

CREATE TABLE sys_user_role (
  id number(20) NOT NULL ,
  user_id number(20) ,
  role_id number(20) ,
  constraint PK_sys_user_role primary key(id));
  
create sequence sys_sys_user_role

  minvalue  1

  maxvalue  999999999999999999999999999

  start  with  200

  increment  by  1

  cache  20;
  
            CREATE OR REPLACE TRIGGER sys_user_role_trigger
 BEFORE
  INSERT
 ON sys_user_role
REFERENCING NEW AS NEW OLD AS OLD
 FOR EACH ROW
BEGIN
   SELECT sys_sys_user_role.NEXTVAL
     INTO :NEW.id
     FROM DUAL;
END;

