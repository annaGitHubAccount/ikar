insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (1, 1, '345676548', 'Mariusz', 'Pudzian', parsedatetime('17.08.2000', 'dd.MM.yyyy'), 'GD');
insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (2, 2, '467887549', 'Kora', 'Jackowska', parsedatetime('06.01.2019', 'dd.MM.yyyy'), 'SB');
insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (3, 3, '256787543', 'Maja', 'Morowska', parsedatetime('02.05.2010', 'dd.MM.yyyy'), 'BR');
insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (4, 4, '256787543', 'Monika', 'Ferna', parsedatetime('03.08.1980', 'dd.MM.yyyy'), 'BR');
insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (5, 5, '256787543', 'Sabrina', 'Wolna', parsedatetime('08.10.1986', 'dd.MM.yyyy'), 'GD');
insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (6, 6, '256787543', 'Robert', 'Kowalski', parsedatetime('11.07.1978', 'dd.MM.yyyy'), 'GD');

insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (1, 'P01', 'Produkt1', 100, true, 'L');
insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (2, 'P02', 'Produkt2', 250, true, 'S');
insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (3, 'P03', 'Produkt3', 500, false, 'M');
insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (4, 'P04', 'Produkt4', 1000, true, 'L');
insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (5, 'P05', 'Produkt5', 1000, false, 'M');
insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (6, 'P06', 'Produkt6', 1000, true, 'S');

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(1, 'Polska' ,'Warszawa', 'Solidarnosci', '54a', 'MA', 1);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(2, 'Polska','Rzeszow', 'Siemiradzkiego', '76', 'PA', 1);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(3, 'Deutschland', 'Nürnberg', 'Lange Str.', '11b', 'MA', 2);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(4, 'Deutschland', 'München', 'Kurze Str.', '13', 'PA', 2);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(5, 'Polska', 'Warszawa', 'Wojska Polskiego', '11', 'MA', 3);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(6, 'Polska', 'Krakow', 'Nowotki', '13', 'PA', 3);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(7, 'Deutschland', 'Frankfurt', 'Bahnhof Str.', '13', 'MA', 4);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(8, 'Deutschland', 'Frankfurt', 'Bahnhof Str.', '13', 'PA', 4);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(9, 'Polska', 'Warszawa', 'Chelmonskiego', '21', 'MA', 5);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(10, 'Polska', 'Warszawa', 'Chelmonskiego', '21', 'PA', 5);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(11, 'Deutschland', 'München', 'Blumen Str.', '4', 'MA', 6);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(12, 'Deutschland', 'München', 'Blumen Str.', '4', 'PA', 6);

insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES (1, 'PO1', 'Produkt1', 100, true, 'L', 1);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES (2, 'PO2', 'Produkt2', 250, true, 'S', 1);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(3, 'P03', 'Produkt3', 500, false, 'M', 2);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(4, 'P04', 'Produkt4', 1000, true, 'L', 2);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(5, 'P05', 'Produkt5', 1000, false, 'M', 3);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(6, 'P06', 'Produkt6', 1000, true, 'S', 3);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(7, 'P04', 'Produkt4', 1000, true, 'L', 4);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(8, 'P05', 'Produkt5', 1000, false, 'M', 5);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(9, 'P04', 'Produkt4', 1000, true, 'L', 6);
insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES(10, 'P05', 'Produkt5', 1000, false, 'M', 6);

insert into Rolle(id, name, KUNDE_ID) VALUES (1, 'Scrum Master', 1);
insert into Rolle(id, name, KUNDE_ID) VALUES (2, 'Entwickler', 1);
insert into Rolle(id, name, KUNDE_ID) VALUES (3, 'Produkt Owner', 2);
insert into Rolle(id, name, KUNDE_ID) VALUES (4, 'Entwickler', 3);
insert into Rolle(id, name, KUNDE_ID) VALUES (6, 'Scrum Master', 4);
insert into Rolle(id, name, KUNDE_ID) VALUES (7, 'Entwickler', 5);
insert into Rolle(id, name, KUNDE_ID) VALUES (8, 'Produkt Owner', 5);
insert into Rolle(id, name, KUNDE_ID) VALUES (9, 'Entwickler', 6);

insert into Rolle_Stammdaten(id, name) VALUES (1, 'Scrum Master');
insert into Rolle_Stammdaten(id, name) VALUES (2, 'Entwickler');
insert into Rolle_Stammdaten(id, name) VALUES (3, 'Produkt Owner');