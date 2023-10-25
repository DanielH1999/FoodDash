use FoodDash;
show tables;

-- inserto clientes en la bd
describe cliente;
insert into cliente values(40345765, 'David Bermudez', 'Yatay 428', '1512348765');
insert into cliente values(35765123, 'Oscar', 'AV. Rivadavia 1060', '1112348765');

select * from cliente;

-- inserto restaurants en la bd
describe restaurant;
insert into restaurant values(default, default, default, 'El Tano', '1111111111');
insert into restaurant (nombre, telefono) values('Taco Bar', '1187654567');
insert into restaurant (nombre, telefono) values('Hamburgueseria', '1198783412');
insert into restaurant (nombre, telefono) values('KFC', '1198786567');
insert into restaurant (nombre, telefono) values('Heladeria que frio', '1123325678');

select * from restaurant;

-- inserto pedidos en la bd
describe pedido;
insert into pedido values (default, '12345678', '3', 'Hamburguesa', '3', '30000', '15', 'listo');
insert into pedido values (default, '12345679', '4', 'Combo tacos ranchero', '2', '60000', '30', 'listo');
insert into pedido values (default, '12345680', '3', 'Hamburguesa triple con papas', '4', '160000', '10', 'listo');

select * from pedido;

-- inserto envios en la bd
describe envio;
insert into envio values (default, 3, '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'entregado');
insert into envio values (default, 2, '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'pendiente');
insert into envio values (default, 1, '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'entregado');

select * from envio;