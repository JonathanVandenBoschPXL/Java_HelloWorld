alter table antwoord drop column opmerking;
alter table subfunctie add opmerking varchar(255);
alter table subfunctie add prioriteit bit not null;
