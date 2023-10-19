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
nombre varchar(20) not null,
telefono int
);

create table if not exists pedido(
id_pedido int auto_increment primary key,
id_cliente int,
foreign key (id_cliente) references cliente(id_cliente) on delete cascade,
id_restaurant int,
foreign key (id_restaurant) references restaurant(id_restaurant) on delete cascade,
productos varchar(255),
cantidades varchar(255),
suma_precio float not null,
tiempo_preparacion float,
estado varchar(10)
);

ALTER TABLE restaurant ADD CONSTRAINT FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) on delete cascade;

create table if not exists envio(
id_envio int auto_increment primary key,
id_cliente int not null,
id_pedido int not null,
id_restaurant int not null,
direccion varchar(40) not null,
medio_pago varchar(10) not null,
precio_envio float not null,
estado varchar(10)
);

-- alter table envio add constraint foreign key (id_cliente) references cliente(id_cliente) on delete cascade;
-- alter table envio add constraint foreign key (id_pedido) references pedido(id_pedido) on delete cascade;
-- alter table envio add constraint foreign key (id_restaurant) references restaurant(id_restaurant) on delete cascade;
ALTER TABLE envio ADD CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) on delete cascade;
ALTER TABLE envio ADD CONSTRAINT FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) on delete cascade;
ALTER TABLE envio ADD CONSTRAINT FOREIGN KEY (id_restaurant) REFERENCES restaurant(id_restaurant) on delete cascade;
