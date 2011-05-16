/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011-05-11 00:10:43                          */
/*==============================================================*/


drop table if exists cus$customer;

drop table if exists mfg$contact;

drop table if exists mfg$cus_contact;

drop table if exists mfg$customer_biz;

/*==============================================================*/
/* Table: cus$customer                                          */
/*==============================================================*/
create table cus$customer
(
   cus_id               bigint not null auto_increment,
   cus_no               numeric(10) not null,
   cus_eng_name         varchar(64),
   cus_chn_name         varchar(64) not null,
   area                 numeric(6),
   address              varchar(128),
   zipcode              numeric(6),
   contact_tel          varchar(12),
   backup_tel1          varchar(12),
   backup_tel2          varchar(12),
   fax                  varchar(12),
   cus_eng_intro        varchar(1024),
   cus_chn_intro        varchar(1024),
   website              varchar(256),
   remark               varchar(1024),
   status               char(1) not null,
   create_by            numeric(10) not null,
   create_time          date not null,
   update_by            numeric(10) not null,
   update_time          date not null,
   primary key (cus_id)
)
type = Innodb;

/*==============================================================*/
/* Table: mfg$contact                                           */
/*==============================================================*/
create table mfg$contact
(
   contact_id           bigint not null auto_increment,
   contact_name         varchar(32) not null,
   gender               char(1),
   position             varchar(32),
   mobile               varchar(32) not null,
   work_phone           varchar(32),
   email                varchar(32) not null,
   home_phone           varchar(32),
   qq                   varchar(16),
   msn                  varchar(64),
   other                varchar(128),
   status               char(1) not null,
   create_by            numeric(10) not null,
   create_time          date not null,
   update_by            numeric(10) not null,
   update_time          date not null,
   primary key (contact_id)
)
type = Innodb;

/*==============================================================*/
/* Table: mfg$cus_contact                                       */
/*==============================================================*/
create table mfg$cus_contact
(
   cus_contact_id       bigint not null auto_increment,
   cus_id               bigint not null,
   contact_id           bigint not null,
   primary key (cus_contact_id)
)
type = Innodb;

/*==============================================================*/
/* Table: mfg$customer_biz                                      */
/*==============================================================*/
create table mfg$customer_biz
(
   biz_id               bigint not null auto_increment,
   cus_id               bigint not null,
   consultant           numeric(10) not null,
   cs                   numeric(10) not null,
   cooperation          char(1),
   cus_level            char(1),
   gmc_level            char(1),
   receipt_address      varchar(256),
   backup_address1      varchar(256),
   backup_address2      varchar(256),
   shipping_area        numeric(6),
   status               char(1) not null,
   create_by            numeric(10) not null,
   create_time          date not null,
   update_by            numeric(10) not null,
   update_time          date not null,
   primary key (biz_id)
)
type = Innodb;

alter table mfg$cus_contact add constraint FK_Reference_1 foreign key (cus_id)
      references cus$customer (cus_id) on delete restrict on update restrict;

alter table mfg$cus_contact add constraint FK_Reference_2 foreign key (contact_id)
      references mfg$contact (contact_id) on delete restrict on update restrict;

alter table mfg$customer_biz add constraint FK_Reference_3 foreign key (cus_id)
      references cus$customer (cus_id) on delete restrict on update restrict;

