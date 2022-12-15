insert into domein (kleur, naam)
values ('geel', 'stoornissen');

SET @domein_id := last_insert_id();

insert into situering (antwoord1, antwoord2)
values ('Het kind is goed in wiskunde', 'Heeft moeilijkheden met lezen');

SET @situering_id := last_insert_id();

insert into traject (datum_laatst_aangepast, domein_id, kind_id, situering_id, user_id)
values('2022-11-11', @domein_id, 1, @situering_id, 1);

insert into user (rol)
values  ('HULPVERLENER');

SET @user_id := last_insert_id();

insert into user_kind (user_id, kind_id)
values (@user_id, 1);



