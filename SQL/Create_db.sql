/********************************************************
* This script creates the database named ezbuy 
*********************************************************/
DROP DATABASE IF EXISTS ezbuy;
CREATE DATABASE ezbuy;
use ezbuy;

-- create the tables for the database

CREATE TABLE PRODUCT(
product_Code VARCHAR(20) NOT NULL,
product_Name VARCHAR(60),
catalog_Category VARCHAR(50),
description VARCHAR(300),
price double,
image varchar(50),
PRIMARY KEY (product_Code)
);
CREATE TABLE USER(
userID int NOT NULL AUTO_INCREMENT,
firstname VARCHAR(50),
lastname VARCHAR(50),
gender varchar(50),
question varchar(50),
answer varchar(50),
email VARCHAR(100),
address1 VARCHAR(80),
address2 VARCHAR(80),
city VARCHAR(50),
state VARCHAR(50),
pin integer,
country VARCHAR(50),
password VARCHAR(50),
PRIMARY KEY (userID)
);

create table orders
(
	OrderNumber int not null auto_increment,
    date datetime not null default now(),
    userID int not null references user(userID),
    Taxrate double(50,0) not null,
    TotalCost double(50,0) not null,
    Paid bit(1) not null,
    primary key(OrderNumber)
    
    
);

alter table orders auto_increment=58978;

create table OrderItem
(
	OrderNumber int not null references orders(OrderNumber),
    product_Code int not null references product(product_Code),
    Quantity int not null,
    primary key(OrderNumber,product_Code)
);

create table userpass(username varchar(20) not null primary key,
password varchar(20) not null);

create table userrole( username varchar(20) not null,
rollname varchar(15) not null,
primary key(username,rollname));

-- Insert data into the tables

insert into product values ("a1","SONY CYBERSHOT DSC H20","Sony","The Sony Cyber-shot DSC-H20 is a new super-zoom digital camera, offering a 10x image stabilized Carl Zeiss lens covering a focal range of 38-380mm, housed in a compact, go-anywhere package",150.0,"1image.jpg");
insert into product values ("a2","SONY 14.1 Mega Pixel W Series","Sony","The Sony 14.1 Mega Pixel W Series 4x Optical Zoom Cyber-shot is a new super-zoom digital camera, offering a 14x image stabilized Carl Zeiss lens covering a focal range of 26-380mm, housed in a compact, go-anywhere package.",200.0,"item2.jpg");
insert into product values ("a3","SONY Alpha a6000 (black)","Sony","The Sony 24.3 Mega Pixel is a new super-zoom digital camera, offering a 14x image stabilized Carl Zeiss lens covering a focal range of 26-380mm, housed in a compact, go-anywhere package.",300.0,"item3.jpg");  
insert into product values ("a4","NIKON COOLPIX L620","Nikon","Utilizing an 18.1-megapixel CMOS sensor and NIKKOR glass lens, this Nikon Coolpix L620 digital camera makes it easy to take sharp, detailed photos. HD movie mode allows you to capture videos in 1080p with stereo sound. ",40.0,"image 6.jpg");
insert into product values ("a5","NIKON COOLPIX P520","Nikon","The Nikon Coolpix P520 is a new super-zoom compact camera with a mechanically-stabilized 42x optical zoom that offers a massive focal range of 24-1000mm.",500.0,"image 7.jpg");
insert into product values ("a6","NIKON D5100","Nikon","he NIKON D5100 offers a host of new photographic and video tools that deliver superior performance and exceptional image quality with surprising versatility. ",600.0,"image 8.jpg"); 
insert into user(firstname,lastname,email,address1,address2,city,state,pin,country,password,question,answer,gender) values("Selvabharkavi","Sethuramalingam","sbharkavi@gmail.com","UTD","Apt-E","Charlotte","NC",26862,"USA","Generic","What is your Mother's Maiden name?","jayanthi","female");
insert into user(firstname,lastname,email,address1,address2,city,state,pin,country,password,question,answer,gender) values("Miruthulavarshini","Shanmugam","miruthulashan@gmail.com","UTD","Apt-E","Charlotte","NC",26862,"USA","Platinum","What is your Mother's Maiden name?","nirmala","female");

insert into userpass values('admin','admin');
insert into userrole values('admin','admin');