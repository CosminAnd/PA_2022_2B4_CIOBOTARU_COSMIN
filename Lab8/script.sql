CREATE TABLE countries(
id int NOT NULL,
name varchar(20),
code varchar(20),
continent varchar(50)
);

CREATE TABLE continents(
id int NOT NULL,
name varchar(20)
);


CREATE TABLE cities(
id int NOT NULL,
name varchar(50),
country varchar(50),
capital int,
latitude BINARY_DOUBLE,
longitude BINARY_DOUBLE
);



drop table continents;
drop table countries;
drop table cities;

ALTER TABLE cities
ADD PRIMARY KEY (ID);

ALTER TABLE continents
ADD PRIMARY KEY (ID);

ALTER TABLE countries
ADD PRIMARY KEY (name);