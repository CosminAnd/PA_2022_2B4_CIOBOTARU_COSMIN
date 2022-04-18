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



drop table continents;
drop table countries;