-- public.usuario_aud definition

-- Drop table

-- DROP TABLE usuario_aud;

CREATE TABLE usuario_aud (
	id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
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
	CONSTRAINT usuario_aud_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fk74gdm3bhlqa3diq16ouihfq6e FOREIGN KEY (rev) REFERENCES revinfo(rev)
);