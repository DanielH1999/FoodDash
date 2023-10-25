use FoodDash;
show tables;

-- inserto clientes en la bd
describe cliente;
insert into cliente values(12345678, "(test) Karl", "305 - 14th Ave. S. Suite 3B", "1500000000");
insert into cliente (id_cliente, nombre, direccion, telefono)
values(12345679, "(test) Matti", "Keskuskatu 45", "1500000001");
insert into cliente (id_cliente, nombre, direccion, telefono)
values(12345680, "(test) Tom", "ul. Filtrowa 68", "1500000002");

select * from cliente;

-- inserto restaurants en la bd

-- inserto pedidos en la bd

-- inserto envios en la bd