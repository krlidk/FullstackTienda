
CREATE DATABASE db_ecomarket_tienda;

INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Cepillo de dientes de bambú', 2.50);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Bolsa reutilizable de algodón', 3.75);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Detergente ecológico', 5.90);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Shampoo sólido orgánico', 4.80);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Jabón natural artesanal', 3.20);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Desodorante sin aluminio', 4.50);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Rasuradora reutilizable de acero', 9.99);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Pajillas de acero inoxidable', 2.80);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Botella reutilizable de vidrio', 7.45);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Envases de comida compostables', 6.70);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Cera vegetal para envolver alimentos', 5.30);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Papel higiénico reciclado', 4.10);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Toallas femeninas reutilizables', 6.99);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Cubiertos de bambú', 3.40);
INSERT INTO producto (nombre_producto, precio_producto) VALUES ('Filtro de agua sin plástico', 12.00);



INSERT INTO tienda (direccion_tienda, nombre_tienda)
VALUES ('Santiago, Sector Norte, Local 1', 'EcoMarket Norte');

INSERT INTO tienda (direccion_tienda, nombre_tienda)
VALUES ('Viña del mar, Centro Comercial Plaza Verde', 'Ecomarket Plaza Verde');

INSERT INTO tienda (direccion_tienda, nombre_tienda)
VALUES ('Valparaíso, Zona Ecológica, Stand 5', 'Ecomarket zona Ecológica');

INSERT INTO tienda (direccion_tienda, nombre_tienda)
VALUES ('Santiago, Edificio Aurora, Piso 2', 'Ecomarket Aurora');

INSERT INTO tienda (direccion_tienda, nombre_tienda)
VALUES ('La Calera, EcoParque Local 10', 'Ecomarket EcoParque');



INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-01', 'Juan Pérez', 14.40, 1);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-01', 'María López', 7.00, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-02', 'Carlos Rojas', 14.00, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-02', 'Laura Gómez', 14.79, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-03', 'Diego Torres', 14.55, 5);

INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-03', 'Sofía Martínez', 18.79, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-04', 'Francisco Díaz', 8.60, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-04', 'Camila Fuentes', 17.59, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-05', 'José Herrera', 14.15, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-05', 'Valentina Castillo', 25.00, 5);

INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-06', 'Matías Reyes', 11.80, 1);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-06', 'Isidora Núñez', 24.39, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-07', 'Gabriel Silva', 9.50, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-07', 'Josefa Ramos', 15.69, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-08', 'Sebastián Vega', 26.60, 5);

INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-08', 'Fernanda Bravo', 15.70, 1);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-09', 'Tomás Morales', 5.70, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-09', 'Antonia Salazar', 17.40, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-10', 'Cristóbal Araya', 15.29, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-10', 'Trinidad Campos', 13.19, 5);

INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-11', 'Renato Cid', 17.00, 1);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-11', 'Florencia Paredes', 7.70, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-12', 'Nicolás Sáez', 14.95, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-12', 'Emilia Figueroa', 31.04, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-13', 'Vicente Lara', 10.40, 5);

INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-13', 'Agustina Peña', 18.49, 1);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-14', 'Joaquín Bustos', 8.50, 2);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Pendiente', '2025-05-14', 'Amanda Carrasco', 15.30, 3);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Enviado', '2025-05-15', 'Daniel Muñoz', 15.89, 4);
INSERT INTO pedido (estado_pedido, fecha_pedido, nombre_cliente, total_pedido, id_tienda) VALUES ('Entregado', '2025-05-15', 'Martina Alarcón', 14.60, 5);






-- Pedido 1
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (1, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (1, 5);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (1, 9);

-- Pedido 2
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (2, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (2, 6);

-- Pedido 3
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (3, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (3, 8);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (3, 11);

-- Pedido 4
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (4, 4);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (4, 7);

-- Pedido 5
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (5, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (5, 10);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (5, 12);

-- Pedido 6
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (6, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (6, 13);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (6, 14);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (6, 3);

-- Pedido 7
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (7, 6);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (7, 12);

-- Pedido 8
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (8, 4);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (8, 7);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (8, 8);

-- Pedido 9
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (9, 9);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (9, 10);

-- Pedido 10
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (10, 5);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (10, 6);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (10, 11);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (10, 15);

-- Pedido 11
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (11, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (11, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (11, 14);

-- Pedido 12
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (12, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (12, 5);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (12, 7);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (12, 9);

-- Pedido 13
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (13, 8);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (13, 10);

-- Pedido 14
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (14, 11);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (14, 13);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (14, 14);

-- Pedido 15
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (15, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (15, 4);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (15, 6);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (15, 8);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (15, 15);

-- Pedido 16
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (16, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (16, 6);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (16, 9);

-- Pedido 17
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (17, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (17, 5);

-- Pedido 18
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (18, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (18, 4);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (18, 10);

-- Pedido 19
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (19, 7);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (19, 11);

-- Pedido 20
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (20, 8);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (20, 13);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (20, 14);

-- Pedido 21
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (21, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (21, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (21, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (21, 4);

-- Pedido 22
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (22, 5);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (22, 6);

-- Pedido 23
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (23, 9);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (23, 12);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (23, 14);

-- Pedido 24
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (24, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (24, 7);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (24, 11);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (24, 15);

-- Pedido 25
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (25, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (25, 6);

-- Pedido 26
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (26, 4);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (26, 10);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (26, 13);

-- Pedido 27
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (27, 1);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (27, 5);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (27, 8);

-- Pedido 28
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (28, 2);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (28, 9);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (28, 12);

-- Pedido 29
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (29, 3);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (29, 7);

-- Pedido 30
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (30, 6);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (30, 10);
INSERT INTO pedido_producto (id_pedido, id_producto) VALUES (30, 14);



INSERT INTO reporte (descripcion_reporte, fecha_reporte, nombre_empleado, nombre_reporte, id_tienda)
VALUES (
  'Resumen de las ventas realizadas en el día, incluyendo productos como cepillos de bambú y bolsas reutilizables.',
  '2025-05-19',
  'Andrea Soto',
  'Reporte de ventas diario',
  1
);

INSERT INTO reporte (descripcion_reporte, fecha_reporte, nombre_empleado, nombre_reporte, id_tienda)
VALUES (
  'Análisis de ventas semanales con detalle de pedidos frecuentes como shampoo sólido y desodorantes ecológicos.',
  '2025-05-19',
  'Carlos Vidal',
  'Reporte de ventas semanal',
  2
);

INSERT INTO reporte (descripcion_reporte, fecha_reporte, nombre_empleado, nombre_reporte, id_tienda)
VALUES (
  'Informe mensual con totales de ventas acumuladas de productos sustentables como botellas de vidrio y cubiertos de bambú.',
  '2025-05-19',
  'Fernanda Ríos',
  'Reporte de ventas mensual',
  3
);

INSERT INTO reporte (descripcion_reporte, fecha_reporte, nombre_empleado, nombre_reporte, id_tienda)
VALUES (
  'Listado de todos los pedidos marcados como entregados en el sistema durante el mes actual.',
  '2025-05-19',
  'Joaquín Navarro',
  'Reporte de pedidos entregados',
  4
);

INSERT INTO reporte (descripcion_reporte, fecha_reporte, nombre_empleado, nombre_reporte, id_tienda)
VALUES (
  'Detalle de pedidos pendientes por despacho, con énfasis en los productos más solicitados.',
  '2025-05-19',
  'Valentina Molina',
  'Reporte de pedidos pendientes',
  5
);

