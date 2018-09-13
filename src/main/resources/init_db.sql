DROP TABLE IF EXISTS city CASCADE;
DROP TABLE IF EXISTS country CASCADE;
DROP TABLE IF EXISTS countrylanguage CASCADE;

-- your code here which creates the tables
CREATE TABLE city (
  id integer,
  name varchar(255)  NOT NULL,
  country_code varchar(3)  NOT NULL,
  county varchar(255)  NOT NULL,
  population integer NOT NULL,
  CONSTRAINT city_pk PRIMARY KEY (id)
);

CREATE TABLE country (
  code varchar(3) unique,
  name varchar(255)  NOT NULL,
  continent varchar(255)  NOT NULL,
  region varchar(255)  NOT NULL,
  surfacearea float NOT NULL,
  sixth_column integer,
  seventh_column integer NOT NULL,
  eighth_column float,
  ninth_column float,
  tenth_column float,
  eleventh_column varchar(255) NOT NULL,
  governmentform varchar(255) NOT NULL,
  thirteenth_column varchar(255),
  capital integer,
  fifteenth_column varchar(255) NOT NULL,
  CONSTRAINT country_pk PRIMARY KEY (code),
  CONSTRAINT country_city_fk FOREIGN KEY (capital) REFERENCES city (id),
  CONSTRAINT continent_chk CHECK (char_length(continent) > 1)
);

CREATE TABLE countrylanguage (
  countrycode varchar(3) not null,
  language varchar(255) not null,
  isofficial boolean not null,
  percentage real not null,
  unique (countrycode, language),
  CONSTRAINT countrylanguage_country_fk FOREIGN KEY (countrycode) REFERENCES country (code)
);