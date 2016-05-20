CREATE database BOOKSTORE;
USE BOOKSTORE;
CREATE TABLE categorys(
	id VARCHAR(100) PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	description VARCHAR(255)
);
CREATE TABLE books(
	id VARCHAR(100) PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	author VARCHAR(100),
	description VARCHAR(255),
	price FLOAT(8,2),
	path VARCHAR(100),
	fileName VARCHAR(100),
	category_id VARCHAR(100),
	CONSTRAINT category_id_fk FOREIGN KEY(category_id) REFERENCES categorys(id)
)
CREATE TABLE USERS(
  id VARCHAR(100) PRIMARY KEY,
  name¡¡VARCHAR(100) NOT NULL,
  password VARCHAR(100)
)