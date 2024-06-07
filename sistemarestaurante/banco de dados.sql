CREATE DATABASE basedadosrestaurante;

USE basedadosrestaurante;

CREATE TABLE funcionarios(
	id int primary key auto_increment,
    nome varchar(50) not null,
    cargo varchar(50) not null,
    salario double not null
);

CREATE TABLE produtos(
	id int primary key auto_increment,
    nome varchar(50) not null,
    descricao varchar(350) not null,
    preco double not null
);

CREATE TABLE restaurante(
	id int primary key auto_increment,
    nome varchar(50) not null,
    numerofuncionarios int not null,
    receitamediamensal double not null
);