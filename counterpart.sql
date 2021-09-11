create database db_counterpart;
use db_counterpart;

create table school
(
    id     bigint primary key auto_increment,
    code   varchar(6),
    name   varchar(20),
    nature varchar(5),
    link   varchar(50)
);

create table attach
(
    id           bigint primary key auto_increment,
    school_id    bigint not null,
    year         int,
    type         varchar(10),
    plans_number int,
    shift_line   int,
    sub_one      int,
    sub_two      int,
    sub_three    int
)