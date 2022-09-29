-- public.usuario definition

-- Drop table

-- DROP TABLE usuario;

CREATE TABLE usuario (
	id int8 NOT NULL,
	criado timestamp NULL,
	modificado timestamp NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	complemento varchar(255) NULL,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	localidade varchar(255) NULL,
	logradouro varchar(255) NULL,
	senha varchar(255) NULL,
	uf varchar(255) NULL,
	usuario varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);