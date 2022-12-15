create table kind
(
    id                  bigint auto_increment
        primary key,
    achternaam          varchar(255) not null,
    geboorte_datum      date         not null,
    rijksregisternummer varchar(255) not null unique ,
    voornaam            varchar(255) not null,
    geslacht            varchar(255) not null
);

create index kind_id
    on kind (id);

create table user
(
    id   bigint       auto_increment
        primary key,
    rol enum('OUDER', 'LEERKRACHT', 'HULPVERLENER') not null
);

create table user_kind
(
    user_id bigint not null,
    kind_id bigint not null,
    PRIMARY KEY (user_id, kind_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (kind_id) REFERENCES kind (id)
);


