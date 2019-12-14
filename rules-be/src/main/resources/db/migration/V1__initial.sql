create table rule
(
    id                     char(36) primary key not null,
    casino                 varchar(100)         not null,
    game_name_contains     varchar(100)         not null,
    game_name_contains_not varchar(100)         not null
)