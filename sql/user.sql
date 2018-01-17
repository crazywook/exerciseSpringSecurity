CREATE TABLE USER

(

no int auto_increment primary key

,id varchar(30) not null

,password varchar(30) not null

,enabled boolean not null

,username varchar(45)
);

CREATE TABLE USER_ROLES

(

id varchar(30) not null

,roles varchar(30) not null

);

insert into user(
	id, password, enabled, username
)values(
	'wook', 1234, true, '±è¼º¿í'
);

insert into user_ROLES

(id, ROLES)

VALUES

-- ((SELECT LAST_INSERT_ID() from user), 'ROLE_USER');
('wook', 'ROLE_USER');









