DROP DATABASE IF EXISTS travel_log;

CREATE DATABASE travel_log;

USE travel_log;

CREATE TABLE Plan (
	planName varchar(50),
	DescriptionPiece VARCHAR(200),
	location VARCHAR(50),
	amountPeople int,
	TotalCost double,
	DueDate DATE,
	PRIMARY KEY(planName)
);
CREATE TABLE Hotel (
	planName varchar(50),
	hotelName VARCHAR(50),
	roomType VARCHAR(50),
	days int,
    TotalCost double,
    foreign key(planName) references Plan(planName)
);
CREATE TABLE ActivitiesTranportation (
	planName varchar(50),
	activities VARCHAR(200),
	descriptionPiece VARCHAR(200),
	tranportation varchar(50),
    TotalCost double,
    foreign key(planName) references Plan(planName)
);
  