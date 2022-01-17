    delete from adresse;
    delete from authorities;
    delete from ort;
    delete from bundesland;
    delete from  produkt;
    delete from rolle;
    delete from kunde;
    delete from land;
    delete from produkt_stammdaten;
    delete from rolle_stammdaten;
    delete from users;

    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (1, '1905K0001', '345676548', 'Mariusz', 'Pudzian', to_date('17.08.2000', 'dd.MM.yyyy'), 'GD');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (2, '1508K0002', '467887549', 'Kora', 'Jackowska', to_date('06.01.2019', 'dd.MM.yyyy'), 'SB');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (3, '1204K0003', '256787875', 'Maja', 'Morowska', to_date('02.05.2010', 'dd.MM.yyyy'), 'BR');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (4, '1706K0004', '256787543', 'Monika', 'Ferna', to_date('03.08.1980', 'dd.MM.yyyy'), 'BR');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (5, '2004K0005', '256765439', 'Sabrina', 'Wolna', to_date('08.10.1986', 'dd.MM.yyyy'), 'GD');
    insert into Kunde(id, kunde_nummer, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (6, '2003K0006', '976547543', 'Robert', 'Kowalski', to_date('11.07.1978', 'dd.MM.yyyy'), 'GD');

    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (1, 'P01', 'Produkt1', 100, true, 'L');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (2, 'P02', 'Produkt2', 250, true, 'S');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (3, 'P03', 'Produkt3', 500, false, 'M');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (4, 'P04', 'Produkt4', 1000, true, 'L');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (5, 'P05', 'Produkt5', 1000, false, 'M');
    insert into Produkt_Stammdaten(id, symbol, name, preis, is_aktiv, PRODUKT_ART) values (6, 'P06', 'Produkt6', 1000, true, 'S');

    insert into Adresse(ID, LAND, BUNDESLAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(1, 'EN', 'London', 'England', '21458', 'St. Andrew St.', '54a', 'MA', 1);
    insert into Adresse(ID, LAND, BUNDESLAND, ORT, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(2, 'EN', 'Birmingham', 'England', '45632', 'Green St.', '76', 'PA', 1);

    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(3, 'DE', 'Nürnberg', 'Bayern', '45987','Lange Str.', '11b', 'MA', 2);
    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(4, 'DE', 'München', 'Bayern', '12589', 'Kurze Str.', '13', 'PA', 2);

    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(5, 'PL', 'Warszawa', 'Polen', '32586', 'Wojska Polskiego', '11', 'MA', 3);
    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(6, 'PL', 'Krakow', 'Polen','05479', 'Nowotki', '13', 'PA', 3);

    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(7, 'DE', 'Frankfurt', 'Hessen', '75896', 'Bahnhof Str.', '13', 'MA', 4);
    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(8, 'DE', 'Frankfurt', 'Hessen', '25896', 'Bahnhof Str.', '13', 'PA', 4);

    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(9, 'PL', 'Warszawa', 'Polen', '45836', 'Chelmonskiego', '21', 'MA', 5);
    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(10, 'PL', 'Warszawa', 'Polen', '65896', 'Chelmonskiego', '21', 'PA', 5);

    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(11, 'DE', 'München', 'Bayern', '58741', 'Blumen Str.', '4', 'MA', 6);
    insert into Adresse(ID, LAND, ORT, BUNDESLAND, POSTLEITZAHL, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(12, 'DE', 'München', 'Bayern', '96325', 'Blumen Str.', '4', 'PA', 6);

    insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES (1, 'P01', 'Produkt1', 100, true, 'L', 1);
    insert into Produkt(id, symbol, name, preis, is_aktiv, PRODUKT_ART, KUNDE_ID) VALUES (2, 'P02', 'Produkt2', 250, true, 'S', 1);
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

    insert into Bundesland(id, name, land_id) VALUES (1, 'Bayern', 1);
    insert into Bundesland(id, name, land_id) VALUES (2, 'Hessen', 1);
    insert into Bundesland(id, name, land_id) VALUES (3, 'Sachsen', 1);
    insert into Bundesland(id, name, land_id) VALUES (4, 'Cambridgeshire', 2);
    insert into Bundesland(id, name, land_id) VALUES (5, 'Hampshire', 2);
    insert into Bundesland(id, name, land_id) VALUES (6, 'Derbyshire', 2);
    insert into Bundesland(id, name, land_id) VALUES (7, 'Mazowieckie', 3);
    insert into Bundesland(id, name, land_id) VALUES (8, 'Warmia i Mazury', 3);
    insert into Bundesland(id, name, land_id) VALUES (9, 'Pomorskie', 3);

    insert into Ort (id, name, bundesland_id) VALUES (1, 'München', 1);
    insert into Ort (id, name, bundesland_id) VALUES (2, 'Nürnberg', 1);
    insert into Ort (id, name, bundesland_id) VALUES (3, 'Frankfurt', 2);
    insert into Ort (id, name, bundesland_id) VALUES (4, 'Wiesbaden', 2);
    insert into Ort (id, name, bundesland_id) VALUES (5, 'Drezden', 3);
    insert into Ort (id, name, bundesland_id) VALUES (6, 'Leipzig', 3);
    insert into Ort (id, name, bundesland_id) VALUES (7, 'Cambridge', 4);
    insert into Ort (id, name, bundesland_id) VALUES (8, 'Peterborough', 4);
    insert into Ort (id, name, bundesland_id) VALUES (9, 'Winchester',5);
    insert into Ort (id, name, bundesland_id) VALUES (10, 'New Forest',5);
    insert into Ort (id, name, bundesland_id) VALUES (11, 'Ashbourne',6);
    insert into Ort (id, name, bundesland_id) VALUES (12, 'Derby',6);
    insert into Ort (id, name, bundesland_id) VALUES (13, 'Warszawa',7);
    insert into Ort (id, name, bundesland_id) VALUES (14, 'Lodz',7);
    insert into Ort (id, name, bundesland_id) VALUES (15, 'Olsztyn',8);
    insert into Ort (id, name, bundesland_id) VALUES (16, 'Ostroda',8);
    insert into Ort (id, name, bundesland_id) VALUES (17, 'Gdansk',9);
    insert into Ort (id, name, bundesland_id) VALUES (18, 'Sopot',9);

    insert into users(username, password, enabled) values('robert', '$2a$12$EEIqrTF5/RIHh2Z7IKnRxepWz2prXuaQ07aVtXfSkDFO1dOCG2EXi', true);
    insert into users(username, password, enabled) values('anna', '$2a$12$EEIqrTF5/RIHh2Z7IKnRxepWz2prXuaQ07aVtXfSkDFO1dOCG2EXi', true);

    insert into authorities(username, authority) values ('robert', 'ROLE_USER');
    insert into authorities(username, authority) values ('anna', 'ROLE_USER');
    insert into authorities(username, authority) values ('anna', 'ROLE_ADMIN');
