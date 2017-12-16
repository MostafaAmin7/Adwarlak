/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/14/2017 8:27:37 PM                        */
/*==============================================================*/


drop table if exists Admin;

drop table if exists `Belong to_C`;

drop table if exists Brands;

drop table if exists Cart;

drop table if exists Categories;

drop table if exists Customer;

drop table if exists Products;

drop table if exists `Shop owner`;

drop table if exists Stores;

drop table if exists User;

drop table if exists bought;

drop table if exists `has a_p`;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   u_name               varchar(50) not null,
   password             varchar(1024) not null,
   mail                 varchar(1024),
   phone                numeric(8,0),
   age                  int,
   type                 int not null,
   level                int not null,
   primary key (u_name)
);

/*==============================================================*/
/* Table: `Belong to_C`                                         */
/*==============================================================*/
create table `Belong to_C`
(
   c_id                 int not null,
   p_id                 int not null,
   primary key (c_id, p_id)
);

/*==============================================================*/
/* Table: Brands                                                */
/*==============================================================*/
create table Brands
(
   b_id                 int not null,
   name                 varchar(1024),
   primary key (b_id)
);

/*==============================================================*/
/* Table: Cart                                                  */
/*==============================================================*/
create table Cart
(
   u_name               varchar(50) not null,
   p_id                 int not null,
   primary key (u_name, p_id)
);

/*==============================================================*/
/* Table: Categories                                            */
/*==============================================================*/
create table Categories
(
   c_id                 int not null,
   name                 varchar(1024),
   primary key (c_id)
);

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table Customer
(
   u_name               varchar(50) not null,
   password             varchar(1024) not null,
   mail                 varchar(1024),
   phone                numeric(8,0),
   age                  int,
   type                 int not null,
   rate                 int,
   primary key (u_name)
);

/*==============================================================*/
/* Table: Products                                              */
/*==============================================================*/
create table Products
(
   p_id                 int not null,
   b_id                 int,
   name                 varchar(1024),
   Description          varchar(1024),
   available            int,
   sold                 int,
   color                varchar(1024),
   price                float,
   primary key (p_id)
);

/*==============================================================*/
/* Table: `Shop owner`                                          */
/*==============================================================*/
create table `Shop owner`
(
   u_name               varchar(50) not null,
   password             varchar(1024) not null,
   mail                 varchar(1024),
   phone                numeric(8,0),
   age                  int,
   type                 int not null,
   `start date`         int,
   `end date`           int,
   premium              int,
   rate                 int,
   primary key (u_name)
);

/*==============================================================*/
/* Table: Stores                                                */
/*==============================================================*/
create table Stores
(
   s_id                 int not null,
   u_name               varchar(50),
   name                 varchar(1024),
   address              varchar(1024),
   primary key (s_id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   u_name               varchar(50) not null,
   password             varchar(1024) not null,
   mail                 varchar(1024),
   phone                numeric(8,0),
   age                  int,
   type                 int not null,
   primary key (u_name)
);

/*==============================================================*/
/* Table: bought                                                */
/*==============================================================*/
create table bought
(
   u_name               varchar(50) not null,
   p_id                 int not null,
   primary key (u_name, p_id)
);

/*==============================================================*/
/* Table: `has a_p`                                             */
/*==============================================================*/
create table `has a_p`
(
   s_id                 int not null,
   p_id                 int not null,
   avail                int,
   sold                 int,
   primary key (s_id, p_id)
);

alter table Admin add constraint `FK_is a_a` foreign key (u_name)
      references User (u_name) on delete restrict on update restrict;

alter table `Belong to_C` add constraint `FK_Belong to_C` foreign key (c_id)
      references Categories (c_id) on delete restrict on update restrict;

alter table `Belong to_C` add constraint `FK_Belong to_C2` foreign key (p_id)
      references Products (p_id) on delete restrict on update restrict;

alter table Cart add constraint FK_Cart foreign key (u_name)
      references User (u_name) on delete restrict on update restrict;

alter table Cart add constraint FK_Cart2 foreign key (p_id)
      references Products (p_id) on delete restrict on update restrict;

alter table Customer add constraint `FK_is a_c` foreign key (u_name)
      references User (u_name) on delete restrict on update restrict;

alter table Products add constraint `FK_Belong to` foreign key (b_id)
      references Brands (b_id) on delete restrict on update restrict;

alter table `Shop owner` add constraint `FK_is a_s` foreign key (u_name)
      references User (u_name) on delete restrict on update restrict;

alter table Stores add constraint FK_Own foreign key (u_name)
      references `Shop owner` (u_name) on delete restrict on update restrict;

alter table bought add constraint FK_bought foreign key (u_name)
      references User (u_name) on delete restrict on update restrict;

alter table bought add constraint FK_bought2 foreign key (p_id)
      references Products (p_id) on delete restrict on update restrict;

alter table `has a_p` add constraint `FK_has a_p` foreign key (s_id)
      references Stores (s_id) on delete restrict on update restrict;

alter table `has a_p` add constraint `FK_has a_p2` foreign key (p_id)
      references Products (p_id) on delete restrict on update restrict;

