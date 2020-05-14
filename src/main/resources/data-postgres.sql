    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (1, '1905K0001', '345676548', 'Mariusz', 'Pudzian', to_date('17.08.2000', 'dd.MM.yyyy'), 'GD');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (2, '1508K0002', '467887549', 'Kora', 'Jackowska', to_date('06.01.2019', 'dd.MM.yyyy'), 'SB');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (3, '1204K0003', '256787543', 'Maja', 'Morowska', to_date('02.05.2010', 'dd.MM.yyyy'), 'BR');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (4, '1706K0004', '256787543', 'Monika', 'Ferna', to_date('03.08.1980', 'dd.MM.yyyy'), 'BR');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (5, '2004K0005', '256787543', 'Sabrina', 'Wolna', to_date('08.10.1986', 'dd.MM.yyyy'), 'GD');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (6, '2003K0006', '256787543', 'Robert', 'Kowalski', to_date('11.07.1978', 'dd.MM.yyyy'), 'GD');

    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (1, 'P01', 'Produkt1', 100, true, 'L');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (2, 'P02', 'Produkt2', 250, true, 'S');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (3, 'P03', 'Produkt3', 500, false, 'M');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (4, 'P04', 'Produkt4', 1000, true, 'L');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (5, 'P05', 'Produkt5', 1000, false, 'M');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (6, 'P06', 'Produkt6', 1000, true, 'S');

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(1, 'EN', 'London', '21458', 'St. Andrew St.', '54a', 'MA', 1);
    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(2, 'EN', 'Birmingham', '45632', 'Green St.', '76', 'PA', 1);

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(3, 'DE', 'Nürnberg', '45987','Lange Str.', '11b', 'MA', 2);
    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(4, 'DE', 'München', '12589', 'Kurze Str.', '13', 'PA', 2);

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(5, 'PL', 'Warszawa', '32586', 'Wojska Polskiego', '11', 'MA', 3);
    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(6, 'PL', 'Krakow', '05479', 'Nowotki', '13', 'PA', 3);

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(7, 'DE', 'Frankfurt', '75896', 'Bahnhof Str.', '13', 'MA', 4);
    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(8, 'DE', 'Frankfurt', '25896', 'Bahnhof Str.', '13', 'PA', 4);

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(9, 'PL', 'Warszawa', '45836', 'Chelmonskiego', '21', 'MA', 5);
    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(10, 'PL', 'Warszawa', '65896', 'Chelmonskiego', '21', 'PA', 5);

    insert into Adresse(ID, LAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(11, 'DE', 'München', '58741', 'Blumen Str.', '4', 'MA', 6);
    insert into Adresse(ID, LAND, ORT,  POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(12, 'DE', 'München', '96325', 'Blumen Str.', '4', 'PA', 6);

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

    insert into Land(id, symbol, name) VALUES (1, 'DE', 'Deutschland');
    insert into Land(id, symbol, name) VALUES (2, 'EN', 'England');
    insert into Land(id, symbol, name) VALUES (3, 'PL', 'Polen');

    insert into users(username, password, enabled) values('robert', '$2y$12$VDL36qc/EEBJF8nBDa0ejefecheX2t3DGPgv9.dv2PCVIFS/MofOm', true);
    insert into users(username, password, enabled) values('anna', '$2y$12$VDL36qc/EEBJF8nBDa0ejefecheX2t3DGPgv9.dv2PCVIFS/MofOm', true);

    insert into authorities(username, authority) values ('robert', 'ROLE_USER');
    insert into authorities(username, authority) values ('anna', 'ROLE_USER');
    insert into authorities(username, authority) values ('anna', 'ROLE_ADMIN');
