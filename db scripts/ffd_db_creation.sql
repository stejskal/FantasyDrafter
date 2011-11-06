create table conference
(
  id integer not null primary key,
  name text not null
);
create sequence seqconference start 1;

create table division
(
  id integer not null primary key,
  name text not null,
  conference_id integer not null REFERENCES conference(id)
);
create sequence seqdivision start 1;

CREATE TABLE pro_team
(
   id integer NOT NULL PRIMARY KEY, 
   name text not null, 
   state char(2) NOT NULL, 
   location text,
   division_id integer not null references division(id)
);
create sequence seqpro_team start 1;

create table squad
(
  id integer not null primary key,
  name text not null,
  description text not null
);
create sequence seqsquad start 1;

create table position
(
  id integer not null primary key,
  name text not null,
  description text,
  squad_id integer not null references squad(id)
);
create sequence seqposition start 1;

create table status
(
  id integer not null primary key,
  name text not null,
  description text,
  playable boolean not null
);
create sequence seqstatus start 1;

create table player
(
  id integer not null primary key,
  first_name text not null,
  middle_name text,
  last_name text not null,
  team_id integer references pro_team(id),
  number integer,
  position_id integer not null references position(id),
  status_id integer not null references status(id),
  height integer,
  weight integer,
  birth_date date,
  draft_date date,
  rookie_year integer
);
create sequence seqplayer start 1;