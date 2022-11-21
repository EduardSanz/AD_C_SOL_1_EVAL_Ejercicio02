create schema agenda;
use agenda;

create table personas (
    id int auto_increment primary key ,
    nombre varchar(255) not null ,
    apellidos varchar(500) not null,
    fecha_nacimiento date not null
);

create table direcciones (
    id int auto_increment primary key ,
    calle varchar(150) not null ,
    numero varchar(10) not null ,
    ciudad varchar(100) not null ,
    provincia varchar(100) not null,
    pais varchar(100) not null ,
    id_persona int null ,
    foreign key (id_persona) references personas(id) on update cascade on delete cascade
);


create table contactos (
    id int auto_increment primary key ,
    tipo enum('TELEFONO', 'EMAIL') not null default 'TELEFONO',
    valor varchar(100) ,
    id_persona int null ,
    foreign key (id_persona) references personas(id) on update cascade on delete cascade
);

