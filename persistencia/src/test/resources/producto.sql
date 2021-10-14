insert into ciudad values("Armenia");
insert into ciudad1 values ("Cali");

insert into usuario values("123", "Karla", "karla@gmail.com", "111", ciudad);
insert into usuario values("435", "Maria", "maria@gmail.com", "555", ciudad1);
insert into usuario values("654", "Oscar", "oscar@gmail.com", "654", ciudad);

insert into producto values("televisor", 1, "Smart tv", 1400000.0, LocalDate.of(2022,6,25), 5.5, usuario, miCiudad);
insert into producto values("Celular", 2, "apple", 1400000.0, LocalDate.of(2022,6,25), 5.5, usuario, miCiudad);
insert into producto values("mango", 8, "deli", 16000, LocalDate.of(2022,6,25), 5.5, usuario, miCiudad);

//imagenes producto
insert into producto_imagenes values(1, "televisor");
insert into producto_imagenes values(2, "Celular");
insert into producto_imagenes values(3, "mango");

//telefonos usuario
insert into usuario_telefono values ("123", "31456", "casa");
insert into usuario_telefono values ("123", "34567", "trabajo");

insert into usuario_telefono values ("435", "3456", "casa");
insert into usuario_telefono values ("435", "6533", "trabajo");

insert into usuario_telefono values ("654", "4567", "casa");
insert into usuario_telefono values ("654", "7543", "trabajo");


