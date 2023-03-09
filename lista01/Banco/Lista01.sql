CREATE DATABASE Lista01;
USE Lista01;

CREATE TABLE animal (
  id INT NOT NULL AUTO_INCREMENT,
  classe VARCHAR(45) NOT NULL,
  especie VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
INSERT INTO animal (classe, especie) VALUES ('Mamiféro', 'troglodytes');
