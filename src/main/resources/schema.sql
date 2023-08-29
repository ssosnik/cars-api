create table cars
(
    id long not null auto_increment,
    brand_name varchar(255),
    model varchar(255),
    production_year int,
    price long,
    color varchar(50),
    primary key (id)
);
