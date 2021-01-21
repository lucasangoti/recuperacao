CREATE DATABASE `RECUPERACAO`

CREATE TABLE `alunos` (
`codaluno` int(11) NOT NULL AUTO_INCREMENT,
`nome` varchar(45) DEFAULT NULL,
PRIMARY KEY (`codaluno`)
)

CREATE TABLE `disciplinas` (
`coddisciplina` int(11) NOT NULL AUTO_INCREMENT,
`nome` varchar(45) DEFAULT NULL,
PRIMARY KEY (`coddisciplina`)
)

CREATE TABLE `aluno_disciplina` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`codaluno` int (11) NOT NULL,
`coddisciplina` int(11) NOT NULL,
PRIMARY KEY(`id`)
FOREIGN KEY (`codaluno`)
REFERENCES alunos(`codaluno`)

FOREIGN KEY (`coddisciplina`)
REFERENCES disciplinas(`coddisciplina`)

