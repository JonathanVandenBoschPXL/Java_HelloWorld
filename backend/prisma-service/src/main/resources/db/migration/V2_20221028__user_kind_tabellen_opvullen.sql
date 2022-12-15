insert into kind (achternaam, geboorte_datum, rijksregisternummer, voornaam, geslacht)
values ('Janssen', '2014-01-01', '14010100207', 'Nina', 'vrouwelijk');

SET @kind_id := last_insert_id();

insert into user (rol)
values  ('OUDER');

SET @user_id := last_insert_id();

insert into user_kind (user_id, kind_id)
values (@user_id, @kind_id);

insert into kind (achternaam, geboorte_datum, rijksregisternummer, voornaam, geslacht)
values ('Janssen', '2010-08-14', '10081400267', 'Ella', 'vrouwelijk');

SET @kind_id := last_insert_id();

insert into user_kind (user_id, kind_id)
values (@user_id, @kind_id);

insert into kind (achternaam, geboorte_datum, rijksregisternummer, voornaam, geslacht)
values ('Bergmans', '2008-04-05', '08040500174', 'Daan', 'mannelijk');

SET @kind_id := last_insert_id();

insert into user_kind (user_id, kind_id)
values (@user_id, @kind_id);

insert into kind (achternaam, geboorte_datum, rijksregisternummer, voornaam, geslacht)
values ('Wijckmans', '2007-08-20', '07082097457', 'Bart', 'mannelijk');

SET @kind_id := last_insert_id();

insert into user_kind (user_id, kind_id)
values (@user_id, @kind_id);
