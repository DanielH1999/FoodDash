use FoodDash;
show tables;

-- inserto clientes en la bd
describe cliente;
insert into cliente values(40345765, 'David Bermudez', 'Yatay 428', '1512348765');
insert into cliente values(35765123, 'Oscar', 'AV. Rivadavia 1060', '1112348765');
insert into cliente values(11111112, 'Roman', 'Hipolito Yrigoyen 3122', '1511111111');
insert into cliente values(11111111, 'Miguel', 'Presidente Uriburu 19', '1234567890');

select * from cliente;

-- inserto restaurants en la bd
describe restaurant;
insert into restaurant values(default, default, default, 'El Tano', '1111111111');
insert into restaurant values(default, default, default, 'Taco Bar', '1187654567');
insert into restaurant values(default, default, default, 'Hamburgueseria', '1198783412');
insert into restaurant values(default, default, default, 'KFC', '1198786567');
insert into restaurant values(default, default, default, 'Heladeria que frio', '1123325678');

select * from restaurant;

-- inserto pedidos en la bd
describe pedido;
insert into pedido values (1, 40345765, 3, 'Hamburguesa', '3', 30000, 15, 'listo');
insert into pedido values (2, 35765123, 2, 'Combo tacos ranchero', '2', 60000, 30, 'en preparacion');
insert into pedido values (3, 11111111, 1, 'Hamburguesa triple con papas', '4', 160000, 10, 'enviado');
insert into pedido values (4, 11111112, 2, 'Papas con ceddar', '1', 1500, 15, 'finalizado');

select * from pedido;

-- inserto envios en la bd
describe envio;
insert into envio values (default, 3, 'Yatay 428', 'efectivo', 420.50, 'por retirar');
insert into envio values (default, 2, 'AV. Rivadavia 1060', 'efectivo', 490, 'pendiente');
insert into envio values (default, 1, 'Presidente Uriburu 19', 'efectivo', '450', 'en viaje');
insert into envio values (default, 2, 'Hipolito Yrigoyen 3122', 'tarjeta', 120, 'entregado');

select * from envio;