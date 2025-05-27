drop database  if exists auction_house;
create database auction_house;
use auction_house;

create table user(
                     user_id int primary key auto_increment,
                     username varchar(256) unique not null,
                     email varchar(512) unique not null,
                     password varchar(512) not null
);

-- status 0 ==> Inactivo
-- status 1 ==> Pendiente
-- status 2 ==> Activo
create table auction(
                        auction_id int primary key auto_increment,
                        user_id int not null,
                        title varchar(256) not null,
                        status int default 0,
                        description text,
                        start_date date,
                        end_date date,
                        constraint foreign key(user_id) references user(user_id)
);

create table category(
                         category_id int primary key auto_increment,
                         title varchar(256) not null,
                         description varchar(512)
);

create table product(
                        product_id int primary key auto_increment,
                        title varchar(256) not null,
                        description text,
                        img_url varchar(512) default 'assets/images/backend/auction_placeholder.jpg',
                        starting_bid decimal default 0,
                        current_bid decimal default 0,
                        closing_bid decimal default 0,
                        category_id int not null,
                        auction_id int,
                        foreign key (category_id) references category(category_id),
                        foreign key (auction_id) references auction(auction_id)
);
schema.sql
Mostrando schema.sql.