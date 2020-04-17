create database if not exists store;

use store;
drop table if exists customer;
drop table if exists products;
drop table if exists orders;

create table customers (
	id int(10) not null auto_increment,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	primary key(id)

);

create table products (
	id int(10) not null auto_increment,
	name varchar(25) not null,
	type varchar(50) not null,
	primary key(id)
	
);	

create table orders (
	id int(10) not null auto_increment,
	customer_id int(10) not null,
	product_id int(10) not null,
	primary key(id),
	foreign key (customer_id) references customers(id),
	foreign key (product_id) references products(id)
	

);