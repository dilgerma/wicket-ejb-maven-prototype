create table projects (id integer, title varchar(200), customer varchar(100), description varchar(250));

create table technologies (tech_name varchar(50), description varchar(100));

create table project_technologies (id integer, project_id integer, tech_name varchar(50));

create table project_attachment (id integer, path varchar(20), description varchar(20), project_id integer);

create table contacts_table (id integer, name varchar(200), email varchar(200), reason integer, text varchar, parent_id integer, creationdate date);

create sequence contactSequence start with 0 increment by 1;