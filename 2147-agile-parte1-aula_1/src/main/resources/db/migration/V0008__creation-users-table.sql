CREATE TABLE users (
	id BIGSERIAL,
	name VARCHAR(50),
	email VARCHAR(100),
	password VARCHAR(10),
	info_users VARCHAR(150),
	
	CONSTRAINT pk_users PRIMARY KEY (id)
);
