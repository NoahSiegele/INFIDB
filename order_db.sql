create table Bestellung_Artikel(
	Bestell_ID INT not null,
	Artikel_ID INT not null,
	Menge INT,
	primary key (Bestell_ID, Artikel_ID),
	foreign key (Bestell_id) references bestellung_v3(id),
	foreign key (Artikel_id) references artikel(id)
);

create table Bestellung_v3(
	ID serial primary key,
	Kunde_ID INT not null,
	Adresse_Rechnung_ID INt not null,
	Adresse_Liefer_ID Int not null,
	foreign key(kunde_id) references kunde(id),
	foreign key(adresse_rechnung_id) references adresse(id),
	foreign key(adresse_liefer_id) references adresse(id)
);

create table Artikel(
	ID serial primary key,
	Artikelname Varchar(255) not null,
	Preis double precision not null
);


create table Kunde(
	ID serial primary key,
	TitelV Varchar(255),
	Vorname Varchar(255) not null,
	Nachname Varchar(255) not null,
	TitelN Varchar(255)
);

create table Adresse(
	ID serial primary key,
	Stadt Varchar(255) not null,
	Strasse Varchar(255) not null,
	PLZ Int not null,
	Hnr Varchar(255) not null
);