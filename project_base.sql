create database if not exists FoodDash;
use FoodDash;
create table if not exists cliente(
id_cliente int primary key,
nombre varchar(20) not null,
direccion varchar(40) not null,
telefono varchar(10) not null
);

create table if not exists restaurant(
id_restaurant int auto_increment primary key,
id_pedido int,
foreign key (id_pedido) references pedido(id_pedido) on delete cascade,
nombre varchar(20) not null,
telefono int
);

create table if not exists pedido(
id_pedido int auto_increment primary key,
id_cliente int,
foreign key (id_cliente) references cliente(id_cliente),
id_restaurant int,
foreign key (id_restaurant) references restaurant(id_restaurant),
precio float not null,
tiempo_preparacion float
);

create table if not exists envio(
id_envio int auto_increment primary key,
foreign key (id_cliente) references cliente(id_cliente),
foreign key (id_pedido) references pedido(id_pedido),
foreign key (id_restaurant) references restaurant(id_restaurant),
direccion varchar(40) not null,
medio_pago varchar(10) not null,
precio_envio float not null
);
drop database FoodDash;
show tables;
describe cliente;