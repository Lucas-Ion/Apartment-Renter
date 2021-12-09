DROP DATABASE IF EXISTS propertySystem;
CREATE DATABASE propertySystem;
USE propertySystem;

DROP TABLE IF EXISTS landlordInfo;
CREATE TABLE landlordInfo(
	username varchar(255),
    balance integer,
    primary key(username)
);

DROP TABLE IF EXISTS propertyInfo;
CREATE TABLE propertyInfo(
	propID integer,
    propState varchar(255),
    propType varchar(255),
    numBed integer,
    numBath integer,
    isFurnished varchar(255),
    address varchar(255),
    cityQuadrant char(2),
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
    notification varchar(255),
    userPassword varchar(255),
    primary key (username)
);

DROP TABLE IF EXISTS renterInfo;
CREATE TABLE renterInfo(
	username varchar(255),
    searchCrit varchar(255),
    primary key(username)
);

DROP TABLE IF EXISTS listingInfo;
CREATE TABLE listingInfo(
	renterUserName varchar(255),
    foreign key (renterUserName) references renterInfo(username) ON UPDATE CASCADE
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
    
Insert into userInfo
values("username1", "hy", "huynh", 23, "phone1", "address1", "manager", "", "password1" );

Insert into userInfo
values("username2", "hy2", "huynh2", 13, "phone2", "address2", "renter", "", "password2" );

Insert into userInfo
values("username3", "hy3", "huynh3", 43, "phone3", "address3", "landlord", "", "password3" );

Insert into userInfo
values("username4", "hy4", "huynh4", 21, "phone4", "address4", "renter", "", "password4" );

select * from userinfo;

insert into landlordinfo
values("username3", 5);

Insert into propertyinfo
values(1, "RENTED", "Apartment", 2, 3, true, "Nowhere", "NE", "username3" );

select * from userinfo where (userRole="manager" and age=23);




