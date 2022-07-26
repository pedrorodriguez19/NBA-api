create schema baloncestodb collate utf8mb4_general_ci;

create table ligas
(
    id            int auto_increment primary key,
    nombre        varchar(50) not null,
    ubicacion     varchar(50) null,
    fechaCreacion date        not null
);

create table equipos
(
    id         int auto_increment primary key,
    nombre     varchar(50) not null,
    ciudad     varchar(50) not null,
    estadio    varchar(50) not null,
    titulos    int         not null,
    fundacion  date        null,
    presidente varchar(50) null,
    entrenador varchar(50) null
);

create table equiposliga
(
    id       int auto_increment primary key,
    idLiga   int not null,
    idEquipo int not null,
    constraint equiposliga_equipos_id_fk
        foreign key (idEquipo) references equipos (id),
    constraint equiposliga_ligas_id_fk
        foreign key (idLiga) references ligas (id)
);

create table jugadores
(
    id             int auto_increment primary key,
    nombre         varchar(50)                         not null,
    apellido       varchar(50)                         not null,
    posicion       enum ('guard', 'forward', 'center') null,
    dorsal         int                                 not null,
    edad           int                                 null,
    antiguedadLiga int                                 null,
    titulos        int                                 null,
    idEquipo       int                                 null,
    constraint jugadores_equipos_id_fk
        foreign key (idEquipo) references equipos (id)
);

INSERT INTO baloncestodb.ligas (id, nombre, ubicacion, fechaCreacion) VALUES (1, 'NBA', 'EEUU', '1950-07-13');
INSERT INTO baloncestodb.ligas (id, nombre, ubicacion, fechaCreacion) VALUES (2, 'Euroliga', 'Europa', '2022-07-21');

INSERT INTO baloncestodb.equipos (id, nombre, ciudad, estadio, titulos, fundacion, presidente, entrenador) VALUES (1, 'Lakers', 'Los Angeles', 'Crypto.com arena', 17, '2022-07-15', 'asdasd', 'asdasdas');
INSERT INTO baloncestodb.equipos (id, nombre, ciudad, estadio, titulos, fundacion, presidente, entrenador) VALUES (2, 'Warriors', 'San Francisco', 'Chase Center', 6, '2022-07-01', 'asdfasdf', 'Steve Kerr');
INSERT INTO baloncestodb.equipos (id, nombre, ciudad, estadio, titulos, fundacion, presidente, entrenador) VALUES (3, 'Real Madrid', 'Madrid', 'WiZink Center', 545354, '2022-07-13', 'Florentino Perez', 'Pablo Lason''t');

INSERT INTO baloncestodb.equiposliga (idLiga, idEquipo, id) VALUES (1, 1, 1);
INSERT INTO baloncestodb.equiposliga (idLiga, idEquipo, id) VALUES (1, 2, 2);
INSERT INTO baloncestodb.equiposliga (idLiga, idEquipo, id) VALUES (2, 3, 3);

INSERT INTO baloncestodb.jugadores (id, nombre, apellido, posicion, dorsal, edad, antiguedadLiga, titulos, idEquipo) VALUES (2, 'Stephen', 'Curry', 'guard', 30, 34, 12, 4, 2);
INSERT INTO baloncestodb.jugadores (id, nombre, apellido, posicion, dorsal, edad, antiguedadLiga, titulos, idEquipo) VALUES (3, 'Lebron', 'James', 'forward', 6, 38, 20, 4, 1);
INSERT INTO baloncestodb.jugadores (id, nombre, apellido, posicion, dorsal, edad, antiguedadLiga, titulos, idEquipo) VALUES (4, 'Sergio', 'Llull', 'guard', 23, 35, 123, 5345234, 3);

