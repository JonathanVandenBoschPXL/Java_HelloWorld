insert into user (rol)
values  ('LEERKRACHT');
insert into user (rol)
values  ('LEERKRACHT');
insert into user (rol)
values  ('OUDER');

-- TRAJECT 1 OUDER 1 KIND 1--------------------------------------------------------------------------------------------
insert into domein (kleur, naam)
values ('geel', 'stoornissen');
SET
@domein_id := last_insert_id();

insert into functie(naam, domein_id)
values ('Mentale Functies', @domein_id);
SET
@mfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Sensorische Functies', @domein_id);
SET
@sfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Bewegingssysteem en aan beweging verwante functies', @domein_id);
SET
@bewFunctie := last_insert_id();

-- Mentale functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Centrale Coherentie', @mfFunctie, 'kan moeilijk figuren onderscheiden.', true);
SET
@ccSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Executieve Functies', @mfFunctie, 'aanpassen aan onverwachte omstandigheden gaat moeizaam.', false);
SET
@efSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Theory of Mind', @mfFunctie, null, false);
SET
@tomSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Socio-emotionele ontwikkeling', @mfFunctie, null, true);
SET
@socioSubFunctie := last_insert_id();
-- Sensorische functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Sensorische Functie', @sfFunctie, 'Fladderen.', false);
SET
@sfSubFunctie := last_insert_id();
-- Bewegingsfunctie
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Bewegingsfunctie', @bewFunctie, 'kan moeilijk schrijven.', true);
SET
@bewSubFunctie := last_insert_id();

--  Antwoorden
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Gericht op details', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Moeizaam het geheel zien', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Vaardigheden zijn contextafhankelijk', @ccSubFunctie);
-- ef
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Responsinhibitie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Werkgeheugen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Emotie-Regulatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Volgehouden aandacht', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Taakinitiatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Planning', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Organisatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Timemanagement', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Doelgericht handelen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Flexibiliteit', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Metacognitie', @efSubFunctie);
-- ToM
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Letterlijk begrijpen van taal', @tomSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Moeite met perspectiefname', @tomSubFunctie);
-- Socio
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Persoonlijkheid', @socioSubFunctie);
-- sf
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Overprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Onderprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Visuele denkers', @sfSubFunctie);
-- bew
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Beperkte grove of fijnmotorische vaardigheden', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Hoge spierspanning - houterig bewegen - tenengang', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Beperkte coördinatievermogen bij motorische handelingen', @bewSubFunctie);

insert into situering (antwoord1, antwoord2)
values ('Het kind is goed in wiskunde', 'Heeft moeilijkheden met lezen');
SET
@situering_id := last_insert_id();

insert into traject (datum_laatst_aangepast, domein_id, kind_id, situering_id, user_id)
values ('2022-11-11', @domein_id, 1, @situering_id, 1);

-- TRAJECT 2 HULPVERLENER 1 KIND 1-------------------------------------------------------------------------------------
insert into domein (kleur, naam)
values ('geel', 'stoornissen');
SET
@domein_id := last_insert_id();

insert into functie(naam, domein_id)
values ('Mentale Functies', @domein_id);
SET
@mfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Sensorische Functies', @domein_id);
SET
@sfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Bewegingssysteem en aan beweging verwante functies', @domein_id);
SET
@bewFunctie := last_insert_id();

-- Mentale functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Centrale Coherentie', @mfFunctie, 'taken tot in de puntjes uitwerken.', true);
SET
@ccSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Executieve Functies', @mfFunctie, 'snel antwoorden, zonder goed na te denken.', false);
SET
@efSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Theory of Mind', @mfFunctie, null, false);
SET
@tomSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Socio-emotionele ontwikkeling', @mfFunctie, 'goedgelovig.', true);
SET
@socioSubFunctie := last_insert_id();
-- Sensorische functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Sensorische Functie', @sfFunctie, 'Loopt weg bij teveel prikkels.', false);
SET
@sfSubFunctie := last_insert_id();
-- Bewegingsfunctie
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Bewegingsfunctie', @bewFunctie, 'loopt stroef.', true);
SET
@bewSubFunctie := last_insert_id();

-- Antwoorden
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Gericht op details', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Moeizaam het geheel zien', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Vaardigheden zijn contextafhankelijk', @ccSubFunctie);
-- ef
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Responsinhibitie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Werkgeheugen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Emotie-Regulatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Volgehouden aandacht', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Taakinitiatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Planning', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Organisatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Timemanagement', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Doelgericht handelen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Flexibiliteit', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Metacognitie', @efSubFunctie);
-- ToM
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Letterlijk begrijpen van taal', @tomSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Moeite met perspectiefname', @tomSubFunctie);
-- Socio
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Persoonlijkheid', @socioSubFunctie);
-- sf
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Overprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Onderprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Visuele denkers', @sfSubFunctie);
-- bew
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Beperkte grove of fijnmotorische vaardigheden', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Hoge spierspanning - houterig bewegen - tenengang', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Beperkte coördinatievermogen bij motorische handelingen', @bewSubFunctie);

insert into situering (antwoord1, antwoord2)
values ('Het kind is goed in wiskunde', 'Heeft moeilijkheden met lezen');
SET
@situering_id := last_insert_id();


insert into traject (datum_laatst_aangepast, domein_id, kind_id, situering_id, user_id)
values ('2022-11-12', @domein_id, 1, @situering_id, 2);

-- ---------------------------------------------------------------------------------------------------------------------
-- TRAJECT 3 LEERKRACHT 1 KIND 1-------------------------------------------------------------------------------------
insert into domein (kleur, naam)
values ('geel', 'stoornissen');
SET
@domein_id := last_insert_id();

insert into functie(naam, domein_id)
values ('Mentale Functies', @domein_id);
SET
@mfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Sensorische Functies', @domein_id);
SET
@sfFunctie := last_insert_id();
insert into functie(naam, domein_id)
values ('Bewegingssysteem en aan beweging verwante functies', @domein_id);
SET
@bewFunctie := last_insert_id();

-- Mentale functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Centrale Coherentie', @mfFunctie, 'taken tot in de puntjes uitwerken.', true);
SET
@ccSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Executieve Functies', @mfFunctie, 'snel antwoorden, zonder goed na te denken.', false);
SET
@efSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Theory of Mind', @mfFunctie, null, false);
SET
@tomSubFunctie := last_insert_id();
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Socio-emotionele ontwikkeling', @mfFunctie, null, true);
SET
@socioSubFunctie := last_insert_id();
-- Sensorische functies
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Sensorische Functie', @sfFunctie, 'Loopt uit het leslokaal.', false);
SET
@sfSubFunctie := last_insert_id();
-- Bewegingsfunctie
insert into subfunctie(naam, functie_id, opmerking, prioriteit)
values ('Bewegingsfunctie', @bewFunctie, 'loopt stroef en praat moeilijk.', true);
SET
@bewSubFunctie := last_insert_id();

-- Antwoorden
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Gericht op details', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Moeizaam het geheel zien', @ccSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Vaardigheden zijn contextafhankelijk', @ccSubFunctie);
-- ef
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Responsinhibitie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Werkgeheugen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Emotie-Regulatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Volgehouden aandacht', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Taakinitiatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Planning', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Organisatie', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Timemanagement', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Doelgericht handelen', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Flexibiliteit', @efSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Metacognitie', @efSubFunctie);
-- ToM
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Letterlijk begrijpen van taal', @tomSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Moeite met perspectiefname', @tomSubFunctie);
-- Socio
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Persoonlijkheid', @socioSubFunctie);
-- sf
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Overprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (false, 'Onderprikkeling', @sfSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Visuele denkers', @sfSubFunctie);
-- bew
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Beperkte grove of fijnmotorische vaardigheden', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Hoge spierspanning - houterig bewegen - tenengang', @bewSubFunctie);
insert into antwoord(ingevuld, naam, subfunctie_id)
values (true, 'Beperkte coördinatievermogen bij motorische handelingen', @bewSubFunctie);

insert into situering (antwoord1, antwoord2)
values ('Het kind is goed in wiskunde', 'Heeft moeilijkheden met lezen');
SET
@situering_id := last_insert_id();


insert into user_kind (user_id, kind_id)
values (3, 1);

insert into traject (datum_laatst_aangepast, domein_id, kind_id, situering_id, user_id)
values ('2022-11-12', @domein_id, 1, @situering_id, 3);

-----------------------------------------------------------------------------------------------------------------------