CREATE DATABASE propertySystem;
USE propertySystem;

DROP TABLE IF EXISTS propertyInfo;
CREATE TABLE propertyInfo(
	propID integer,
    propState varchar(255),
    propType varchar(255),
    numBed integer,
    numBath integer,
    isFurnished varchar(255),
    cityQuadrant char(2),
    address varchar(255),
    landlordUsername varchar(255),
    primary key (propID),
    foreign key (landlordUsername) references landlordInfo(username) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS userInfo;
CREATE TABLE userInfo(
	username varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    age integer,
    phoneNo varchar(255),
    address varchar(255),
    userRole varchar(255),
    userPassword varchar(255),
    primary key (username)
);

DROP TABLE IF EXISTS listingInfo;
CREATE TABLE listingInfo(
	renterUserName varchar(255),
    foreign key (renterUserName) references renterInfo(username) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS landlordInfo;
CREATE TABLE landlordInfo(
	username varchar(255),
    balance integer,
    primary key(username)
);

DROP TABLE IF EXISTS renterInfo;
CREATE TABLE renterInfo(
	username varchar(255),
    searchCrit varchar(255),
    primary key(username)
);

DROP TABLE IF EXISTS managerInfo;
CREATE TABLE managerInfo(
	username varchar(255),
    primary key(username)
);

DROP TABLE IF EXISTS emailMessage;
CREATE TABLE emailMessage(
	messageID integer,
    senderUserName varchar(255),
    receiverUserName varchar(255),
    message varchar(255),
    primary key(messageID)
);

DROP TABLE IF EXISTS fees;
CREATE TABLE fees(
	feeID integer,
	fee integer,
    period integer,
    primary key(feeID)
);

select * from landlordInfo;

insert into renterinfo
values("username2", "Apartment 2 3 true NE");

insert into fees
values(1,2,30);

insert into listinginfo
values("username2");

insert into listinginfo
values("username4");
