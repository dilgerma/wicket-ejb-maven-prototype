create table projects (id integer, title varchar(200), customer varchar(100), description varchar(250));

create table technologies (tech_name varchar(50), description varchar(100));

create table project_technologies (id integer, project_id integer, tech_name varchar(50));

create table contacts_table (id integer, name varchar(200), email varchar(200), reason integer, text varchar, parent_id integer, creationdate date);

create table workshop_table (id integer, title varchar(200), description varchar(200), summary varchar(600));

create table attachments (id integer, path varchar(40), description varchar(200));

create table project_attachment (id integer, project_id integer, attachment_id integer);

create table workshop_attachment (id integer, workshop_id integer, attachment_id integer);

create sequence contactSequence start with 0 increment by 1;