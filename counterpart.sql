create database db_counterpart;
use db_counterpart;

create table score_line
(
    id           bigint primary key auto_increment,
    year         int,
    type         varchar(10),
    code         varchar(6),
    name         varchar(20),
    nature       varchar(5),
    plans_number int,
    shift_line   int,
    sub_one      int,
    sub_two      int,
    sub_three    int,
    link         varchar(50)
);