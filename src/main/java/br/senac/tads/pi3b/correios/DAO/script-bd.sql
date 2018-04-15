create database correios;

use correios;

create table Cliente(
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

create table pacote(
id int not null auto_increment,
idRemetente int not null,
valor float not null,
peso float not null,
altura float not null,
largura float not null,
destinatario varchar(255) not null,
endereco varchar(255) not null,
cidade varchar(255) not null,
estado varchar(255),
status varchar(255) not null,
primary key(id),
foreign key(idRemetente) references cliente(idCliente)
);

create table historico(
dataRegistro date not null,
idHistorico varchar(255) not null,
idPacote varchar(255) not null,
primary key (idHistorico),
foreign key (idPacote) references pacote(id)
);

INSERT INTO cliente (nomeCliente, telefone, cpf, cep, endereco, estado, cidade, email)
VALUES ("tttttttt", "212121597", "38414121", "05689468", "rua ala", "sp", "sao paulo", "digo@gmail.com");

SELECT * FROM cliente;