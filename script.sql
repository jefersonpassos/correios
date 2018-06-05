create database correios;

use correios;

create table cliente(
idCliente int not null auto_increment,
nomeCliente varchar(30) not null,
telefone varchar(15),
cpf varchar(15) not null,
cep varchar(9) not null,
endereco varchar(50),
estado varchar(255),
cidade varchar(255),
email varchar(255),
primary key(idCliente)
);

create table encomenda(
id int not null auto_increment,
idRemetente int not null,
destinatario varchar(255) not null,
endereco varchar(255) not null,
cidade varchar(255) not null,
estado varchar(255) not null,
cep varchar(9) not null,
altura double not null,
largura double not null,
comprimento double not null,
peso double not null,
valor double not null,
posicao varchar(50) not null,
data_postagem timestamp not null,
data_entrega timestamp,
rastreio varchar(150),
primary key(id),
foreign key(idRemetente) references cliente(idCliente)
);

create table usuario (
    id int not null auto_increment,
    nome varchar(100) not null,
    senha varchar(300) not null,
    email varchar(255) not null unique,
    perfil varchar(50) not null,
    filial varchar(50) not null,
    primary key (id)
);

 DELETE FROM usuario
WHERE id = 2;

insert into usuario (nome, email, senha, perfil, filial)
values ('admin', 'admin@teste.com', '$2a$10$xVTCtBLE6.3mcJkdJYwItemHoaJc1C6Z/LPmKChSzPtVPNNyWGbEO', 'admin', 'SP');

insert into usuario (nome, email, senha, perfil, filial)
values ('joao', 'joao@teste.com', '$2a$10$xVTCtBLE6.3mcJkdJYwItemHoaJc1C6Z/LPmKChSzPtVPNNyWGbEO', 'estoquista', 'PE');

insert into usuario (nome, email, senha, perfil, filial)
values ('teste', 'teste@teste.com', '$2a$10$xVTCtBLE6.3mcJkdJYwItemHoaJc1C6Z/LPmKChSzPtVPNNyWGbEO', 'estoquista', 'PE');


SELECT * FROM correios.encomenda WHERE data_postagem BETWEEN ('2018-05-27') AND ('2018-06-18 00:00:00');
SELECT * FROM correios.encomenda WHERE data_postagem BETWEEN ('05-27-2018') AND ('06-11-2018');
