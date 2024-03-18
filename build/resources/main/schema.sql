DROP TABLE IF EXISTS exchange;

create table exchange(
    id int auto_increment primary key,
    source_currency varchar(255) not null,
    target_currency varchar(255) not null,
    rate varchar(255) not null
);
