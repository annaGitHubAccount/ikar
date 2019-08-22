CREATE SEQUENCE kunde_seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE produkt_stammdaten__seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE ADRESSE_SEQ
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;


create table Kunde
(
    id       long primary key auto_increment not null,
    steuer_id   varchar(50) not null,
    name      varchar(50)  not null,
    nachname  varchar(50)  not null,
    birth_date date not null,
    KUNDE_ART varchar(50)
);

create table Produkt_Stammdaten
(
  id    long primary key auto_increment not null,
  symbol    varchar(3) not null,
  name     varchar(50)  not null,
  preis    decimal(20)  not null,
  is_aktiv   boolean not null,
  PRODUKT_ART varchar(50)
);

create table Adresse
(
    ID number(10) NOT NULL,
    LAND VARCHAR(50) NOT NULL,
    ORT VARCHAR(50) NOT NULL,
    STRASSE VARCHAR2(50) NOT NULL,
    HAUS_NR VARCHAR(10) NOT NULL,
    KUNDE_ID NUMBER(10) NOT NULL,
    ADRESSE_ART VARCHAR(2) NOT NULL,
    CONSTRAINT ADRESSE_PK PRIMARY KEY(ID),
    CONSTRAINT ADRESSE_KUNDE_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);

create table Produkt
(
    id    long primary key auto_increment not null,
    symbol    varchar(4) not null,
    name     varchar(50)  not null,
    preis    decimal(20)  not null,
    is_aktiv   boolean not null,
    PRODUKT_ART varchar(50),
    KUNDE_ID NUMBER(10) NOT NULL,
    CONSTRAINT Produkt_PK PRIMARY KEY(ID),
    CONSTRAINT Produkt_Kunde_FK FOREIGN KEY(KUNDE_ID) REFERENCES Kunde(ID)
);