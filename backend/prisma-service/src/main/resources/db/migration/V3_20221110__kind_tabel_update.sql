ALTER TABLE kind
ADD COLUMN adres VARCHAR(100) AFTER voornaam;

ALTER TABLE kind
ADD COLUMN school VARCHAR(100) AFTER adres,
ADD COLUMN klas VARCHAR(100) AFTER school;

UPDATE kind SET adres = 'Kerkstraat 1 Hasselt 3500' WHERE id=1;
UPDATE kind SET school = 'Jan Rosier' WHERE id=1;
UPDATE kind SET klas = '1C' WHERE id=1;

UPDATE kind SET adres = 'Kerkstraat 1 Hasselt 3500' WHERE id=2;
UPDATE kind SET school = 'Jan Rosier' WHERE id=2;
UPDATE kind SET klas = '1C' WHERE id=2;

UPDATE kind SET adres = 'Dorpplain 25 Hasselt 3500' WHERE id=3;
UPDATE kind SET school = 'Jan Rosier' WHERE id=3;
UPDATE kind SET klas = '1C' WHERE id=3;

UPDATE kind SET adres = 'Peerderbaan 69 Neerpelt 3910' WHERE id=4;
UPDATE kind SET school = 'Sint Maria' WHERE id=4;
UPDATE kind SET klas = '5Handel' WHERE id=4;

