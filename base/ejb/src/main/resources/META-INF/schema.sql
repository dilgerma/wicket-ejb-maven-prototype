create table projects (id integer, title varchar(200), customer varchar(100), description varchar(250));

create table technologies (tech_name varchar(50), description varchar(100));

create table project_technologies (id integer, project_id integer, tech_name varchar(50));

create table project_attachment (id integer, path varchar(20), description varchar(20), project_id integer);
