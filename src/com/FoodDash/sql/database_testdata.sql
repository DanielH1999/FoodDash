use FoodDash;
show tables;

-- inserto clientes en la bd
describe cliente;
insert into cliente values(12345678, "(test) Karl", "305 - 14th Ave. S. Suite 3B", "1500000000");
insert into cliente (id_cliente, nombre, dirrestauranteccion, telefono)
values(12345679, "(test) Matti", "Keskuskatu 45", "1500000001");
insert into cliente (id_cliente, nombre, direccion, telefono)
values(12345680, "(test) Tom", "ul. Filtrowa 68", "1500000002");
insert into cliente values(40345765, 'David Bermudez', 'Yatay 428', '1512348765');
insert into cliente values(35765123, 'Oscar', 'AV. Rivadavia 1060', '1112348765');

select * from cliente;

-- inserto restaurants en la bd
describe restaurant;
insert into restaurant values(null, null, 'Mi Barrio', '1543213456');
insert into restaurant values(null, null, 'Taco Bar', '1187654567');
insert into restaurant values(null, null, 'Hamburgueseria', '1198783412');
insert into restaurant values(1, null, 'KFC', '1198786567');
insert into restaurant values(2, null, 'Heladeria que frio', '1123325678');

select * from cliente;
select * from restaurant;

-- inserto pedidos en la bd
describe pedido;
insert into pedido values (null, '12345678', '3', 'Hamburguesa', '3', '30000', '15', 'listo');
insert into pedido values (null, '12345679', '4', 'Combo tacos ranchero', '2', '60000', '30', 'listo');
insert into pedido values (null, '12345680', '3', 'Hamburguesa triple con papas', '4', '160000', '10', 'listo');
insert into pedido values (2, '12345678', '3', 'Hamburguesa triple con papas', '4', '160000', '10', 'listo');


select * from pedido;

insert into envio values (null, '12345678', '1', '3', '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'entregado');
insert into envio values (null, '12345678', '2', '3', '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'pendiente');
insert into envio values (null, '12345678', '3', '2', '305 - 14th Ave. S. Suite 3B', 'efectivo', '450', 'entregado');