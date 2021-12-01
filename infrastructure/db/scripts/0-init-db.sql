SET
foreign_key_checks = 0;

create database if not exists temperature;
use temperature;

create table if not exists temperature
(
    id                int    not null auto_increment,
    temperature_value double not null,
    temperature_date  timestamp,
    primary key (id)
);

SET
foreign_key_checks = 1;