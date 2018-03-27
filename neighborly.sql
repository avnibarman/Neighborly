DROP DATABASE IF EXISTS Neighborly; /*THIS IS THE MOST DANGEROUS LINE OF SQL CODE */

CREATE DATABASE Neighborly; 
USE Neighborly;

CREATE TABLE User (
	userID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NULL,
    email VARCHAR(100) NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    image VARCHAR(300) NOT NULL,
    address VARCHAR(300) NULL,
    lendingCredits INT(11)
	
);

CREATE TABLE Item (
	itemID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    posterID INT(11), -- foreign key from user table
    borrowerID INT(11), -- foreign key from user table
    status INT(1), -- 0 its available, 1 it's not
    image VARCHAR(300),
    description VARCHAR(500),
    categories VARCHAR(300), -- concatenated string of categories, split by comma
    datesUnavailable VARCHAR(300), -- concatenated string of categories, split by comma
    communityID INT(11) -- initialized to 0 if no group, foreign key
);

CREATE TABLE CommunityGroup (
	communityID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    image VARCHAR(300) NOT NULL,
    name VARCHAR(50),
    inviteCode VARCHAR(50) -- NULL if there is none 
);

CREATE TABLE UsersInCommunityGroup (
	userID INT(11), -- foreign key
    communityID INT(11) -- foreign key
);

    