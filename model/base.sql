/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/2/24 10:35:24                           */
/*==============================================================*/


drop table if exists privilege_info;

drop table if exists privilege_resource;

drop table if exists resource_info;

drop table if exists role_info;

drop table if exists role_privilege;

drop table if exists user_info;

drop table if exists user_role;

/*==============================================================*/
/* Table: privilege_info                                        */
/*==============================================================*/
create table privilege_info
(
   privilege_id         bigint not null auto_increment,
   privilege_name       varchar(128) not null,
   privilege_value      varchar(128),
   access_type          varchar(32),
   description          varchar(256),
   note                 varchar(512),
   primary key (privilege_id)
)
type = InnoDB;

/*==============================================================*/
/* Table: privilege_resource                                    */
/*==============================================================*/
create table privilege_resource
(
   privilege_resource   bigint not null auto_increment,
   resource_info_id     bigint,
   privilege_id         bigint,
   primary key (privilege_resource)
)
type = InnoDB;

/*==============================================================*/
/* Table: resource_info                                         */
/*==============================================================*/
create table resource_info
(
   resource_id          bigint not null auto_increment,
   resource_name        varchar(512),
   super_id             bigint,
   resource_type        numeric(8),
   load_type            numeric(8),
   access_type          numeric(8),
   app_name             varchar(64),
   description          varchar(256),
   note                 varchar(512),
   primary key (resource_id)
)
type = InnoDB;

/*==============================================================*/
/* Table: role_info                                             */
/*==============================================================*/
create table role_info
(
   role_info_id         bigint not null auto_increment,
   role_name            varchar(128) not null,
   super_role_id        bigint not null,
   description          varchar(256),
   note                 varchar(512),
   primary key (role_info_id)
)
type = InnoDB;

/*==============================================================*/
/* Table: role_privilege                                        */
/*==============================================================*/
create table role_privilege
(
   role_privilege_id    bigint not null auto_increment,
   role_info_id         bigint,
   privilege_id         bigint,
   primary key (role_privilege_id)
)
type = InnoDB;

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_info_id         bigint not null auto_increment,
   login_account        varchar(32) not null,
   user_name            varchar(64) not null,
   first_name           varchar(32),
   last_name            varchar(32),
   login_pwd            varchar(128) not null,
   login_email          varchar(256) not null,
   user_type            numeric(4),
   register_time        datetime,
   user_status          numeric(4),
   primary key (user_info_id),
   unique key AK_Key_login_account (login_account)
)
type = InnoDB;

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_role_id         bigint not null auto_increment,
   role_info_id         bigint,
   user_info_id         bigint,
   primary key (user_role_id)
)
type = InnoDB;

alter table privilege_resource add constraint FK_Reference_5 foreign key (privilege_id)
      references privilege_info (privilege_id) on delete restrict on update restrict;

alter table privilege_resource add constraint FK_Reference_6 foreign key (resource_info_id)
      references resource_info (resource_id) on delete restrict on update restrict;

alter table role_privilege add constraint FK_Reference_3 foreign key (role_info_id)
      references role_info (role_info_id) on delete restrict on update restrict;

alter table role_privilege add constraint FK_Reference_4 foreign key (privilege_id)
      references privilege_info (privilege_id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_1 foreign key (role_info_id)
      references role_info (role_info_id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_2 foreign key (user_info_id)
      references user_info (user_info_id) on delete restrict on update restrict;

