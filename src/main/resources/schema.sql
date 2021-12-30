CREATE SEQUENCE if not exists kunde_id_seq START 100 increment by 1;
CREATE SEQUENCE if not exists kunde_nummer_seq START 100 increment by 1 maxvalue 9999 cycle;
CREATE SEQUENCE if not exists produkt_stammdaten_id_seq START 100 increment by 1;
CREATE SEQUENCE if not exists adresse_id_seq START 100 increment by 1;
CREATE SEQUENCE if not exists produkt_id_seq START 100 increment by 1;
CREATE SEQUENCE if not exists rolle_id_seq START 100 increment by 1;
CREATE SEQUENCE if not exists rolle_stammdaten_id_seq START 100 increment by 1;


create table if not exists Kunde
(
    id INTEGER DEFAULT NEXTVAL('kunde_id_seq'),
    kunde_nummer varchar(9)  unique not null,
    steuer_id   varchar(50) not null,
    name      varchar(50)  not null,
    nachname  varchar(50)  not null,
    birth_date date not null,
    KUNDE_ART varchar(50),
    CONSTRAINT KUNDE_PK PRIMARY KEY(ID)
);

create table if not exists Produkt_Stammdaten
(
  id INTEGER DEFAULT NEXTVAL('produkt_stammdaten_id_seq'),
  symbol    varchar(3) not null,
  name     varchar(50)  not null,
  preis    decimal(20)  not null,
  is_aktiv   boolean not null,
  PRODUKT_ART varchar(50),
  CONSTRAINT Produkt_Stammdaten_PK PRIMARY KEY(ID)
);

create table if not exists Adresse
(
    id INTEGER DEFAULT NEXTVAL('adresse_id_seq'),
    LAND VARCHAR(50) NOT NULL,
    BUNDESLAND VARCHAR(50) NOT NULL,
    ORT VARCHAR(50) NOT NULL,
    POSTLEITZAHL VARCHAR(5) NOT NULL,
    STRASSE VARCHAR(50) NOT NULL,
    HAUS_NR VARCHAR(10) NOT NULL,
    KUNDE_ID INTEGER NOT NULL,
    ADRESSE_ART VARCHAR(2) NOT NULL,
    CONSTRAINT ADRESSE_PK PRIMARY KEY(ID),
    CONSTRAINT ADRESSE_KUNDE_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);

create table if not exists Produkt
(
    id INTEGER DEFAULT NEXTVAL('produkt_id_seq'),
    symbol    varchar(4) not null,
    name     varchar(50)  not null,
    preis    decimal(20)  not null,
    is_aktiv   boolean not null,
    PRODUKT_ART varchar(50),
    KUNDE_ID INTEGER NOT NULL,
    CONSTRAINT Produkt_PK PRIMARY KEY(ID),
    CONSTRAINT Produkt_Kunde_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);

create table if not exists Rolle
(
    id INTEGER DEFAULT NEXTVAL('rolle_id_seq'),
    name varchar(100),
    KUNDE_ID INTEGER NOT NULL,
    CONSTRAINT ROLLE_PK primary key (ID),
    CONSTRAINT ROLLE_KUNDE_FK FOREIGN KEY (KUNDE_ID) REFERENCES Kunde(ID)
);

create table if not exists Rolle_Stammdaten
(
  id INTEGER DEFAULT NEXTVAL('rolle_stammdaten_id_seq'),
  name varchar(100),
  CONSTRAINT Rolle_Stammdaten_PK PRIMARY KEY(ID)
);

create table if not exists Land
(
    id INTEGER,
    symbol varchar(3),
    name varchar(50),
    CONSTRAINT Land_PK PRIMARY KEY (ID)
);

create table if not exists Bundesland
(
    id INTEGER,
    name varchar(50),
    LAND_ID INTEGER NOT NULL,
    CONSTRAINT Bundesland_PK PRIMARY KEY (ID),
    CONSTRAINT BUNDESLAND_LAND_FK FOREIGN KEY (LAND_ID) REFERENCES Land(ID)
);

create table if not exists Ort
(
    id INTEGER,
    name varchar(50),
    BUNDESLAND_ID INTEGER NOT NULL,
    CONSTRAINT Ort_PK PRIMARY KEY (ID),
    CONSTRAINT ORT_BUNDESLAND_FK FOREIGN KEY (BUNDESLAND_ID) REFERENCES Bundesland(ID)
);

create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);


create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

