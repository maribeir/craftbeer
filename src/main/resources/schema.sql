DROP TABLE Beer IF EXISTS;
CREATE TABLE Beer
(
 id bigint(20) NOT NULL auto_increment,
 name varchar(200) NOT NULL,
 ingredients varchar(200) NOT NULL,
 alcoholContent varchar(200) NOT NULL,
 price number NOT NULL,
 category varchar(200) NOT NULL,
 PRIMARY KEY  (id)
);