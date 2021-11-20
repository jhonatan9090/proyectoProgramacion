insert into categoria values (1,"Tecnologia");
insert into categoria values (2,"Accesorios");
insert into categoria values (3,"Electrodomesticos");
insert into ciudad values(1,"Armenia");
insert into ciudad values (2,"Cali");
insert into ciudad values (3,"pereira");
insert into usuario(cod_persona,email,nombre,password,ciudad_usuario_cod_ciudad) values("123", "karla@gmail.com", "karla", "111", 1);
insert into usuario(cod_persona,email,nombre,password,ciudad_usuario_cod_ciudad) values("435", "maria@gmail.com", "maria","564", 2);
insert into usuario(cod_persona,email,nombre,password,ciudad_usuario_cod_ciudad) values("654", "oscar@gmail.com", "oscar", "654", 2);
insert into usuario_telefono values ("123", "31456", "casa");
insert into usuario_telefono values ("123", "34567", "trabajo");
insert into usuario_telefono values ("435", "3456", "casa");
insert into usuario_telefono values ("435", "6533", "trabajo");
insert into usuario_telefono values ("654", "4567", "casa");
insert into usuario_telefono values ("654", "7543", "trabajo");
insert into producto(cod_producto,descripcion,descuento,fecha_limite,nombre,precio,unidades,ciudad_producto_cod_ciudad,usuario_vendedor_cod_persona) values(1, "es bonito", 15.0,"2022/6/25","Televisor",15504.4, 40,1,"123");
insert into producto(cod_producto,descripcion,descuento,fecha_limite,nombre,precio,unidades,ciudad_producto_cod_ciudad,usuario_vendedor_cod_persona) values(2, "esta shido", 15.0,"2023/6/25","computador",1550554.4, 40,1,"435");
insert into producto(cod_producto,descripcion,descuento,fecha_limite,nombre,precio,unidades,ciudad_producto_cod_ciudad,usuario_vendedor_cod_persona) values(3, "esta nuevo", 25.0,"2023/6/8","bicicleta",1550554.4, 40,1,"654");
insert into producto_imagenes values(1, "televisor");
insert into producto_imagenes values(2, "Celular");
insert into producto_imagenes values(3, "mango");
insert into producto_lista_categoria(lista_productos_categorias_cod_producto,lista_categoria_cod_categoria) values(1, 1);
insert into producto_lista_categoria(lista_productos_categorias_cod_producto,lista_categoria_cod_categoria) values(2, 1);
insert into producto_lista_categoria(lista_productos_categorias_cod_producto,lista_categoria_cod_categoria) values(3, 1)

