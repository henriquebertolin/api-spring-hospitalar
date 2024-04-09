ALTER TABLE pacientes
add column sn_paciente_ativo BOOLEAN default TRUE;

ALTER TABLE medicos
add column sn_medico_ativo BOOLEAN default TRUE;

-- Para a tabela 'pacientes'
ALTER TABLE pacientes
ADD COLUMN ds_senha VARCHAR(100) NOT NULL;

-- Para a tabela 'medicos'
ALTER TABLE medicos
ADD COLUMN ds_senha VARCHAR(100) NOT NULL;

create table pacientes (
	cd_paciente serial primary key not null,
	nm_paciente varchar(250) not null,
	ds_cpf varchar(20) not null,
	ds_rg varchar(20) not null,
	dt_nascimento date not null,
	ds_email varchar(250) not null,
	dt_hora_criacao timestamp with time zone default now(),
	dt_hora_alterado timestamp with time zone
);

create table plano_saude (
	cd_plano serial primary key not null,
	nm_plano varchar(200) not null,
	dt_hora_criacao timestamp with time zone default now()
);

create table pacientes_plano (
	cd_paciente_plano serial primary key not null,
	cd_paciente integer not null,
	cd_plano integer not null
);

create table medicos (
	cd_medico serial primary key not null,
	ds_crm varchar(100) not null,
	nm_medico varchar(250) not null,
	ds_cpf varchar(20) not null,
	ds_rg varchar(20) not null,
	dt_nascimento date not null,
	ds_email varchar(250) not null,
	dt_hora_criacao timestamp with time zone default now(),
	dt_hora_alterado timestamp with time zone
);

create table consultas (
	cd_consulta serial primary key not null,
	dt_consulta date not null,
	cd_medico integer not null,
	cd_paciente integer not null
);