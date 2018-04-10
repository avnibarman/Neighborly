DROP DATABASE IF EXISTS Neighborly; /*THIS IS THE MOST DANGEROUS LINE OF SQL CODE */

CREATE DATABASE Neighborly; 
USE Neighborly;

CREATE TABLE Users (
	userID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    image VARCHAR(300) NULL
);

CREATE TABLE Items (
	itemID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ownerID INT(11) NOT NULL,-- foreign key from user table
    borrowerID INT(11), -- foreign key from user table, if its null, means that it is available
    availibility INT(1) NOT NULL,-- 0 its available, 1 it's not
    image VARCHAR(300),
    description VARCHAR(500),
    categories VARCHAR(300),
    FOREIGN KEY fk1(ownerID) REFERENCES Users(userID),
    FOREIGN KEY fk2(borrowerID) REFERENCES Users(userID)
);

CREATE TABLE Categories(
	categoryID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    category VARCHAR(20) NOT NULL
);

    