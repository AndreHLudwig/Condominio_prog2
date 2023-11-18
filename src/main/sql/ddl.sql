create table condominio (
                            id_condominio int auto_increment,
                            nome varchar(200) not null,
                            endereco varchar(400) not null,
                            taxa_mensal_condominio double not null,
                            fator_multiplicador_metragem double not null,
                            valor_vaga_garagem double not null,
                            primary key (id_condominio)
);

create table bloco (
                       id_bloco int auto_increment,
                       id_condominio int not null,
                       nome varchar(100) not null,
                       andares int not null,
                       vagas_de_garagem int not null,
                       primary key (id_bloco),
                       foreign key (id_condominio) references condominio(id_condominio)
);

create table pessoa (
                        id_pessoa int auto_increment,
                        nome varchar(100) not null,
                        telefone varchar(15) not null,
                        email varchar(50) not null,
                        primary key (id_pessoa)
);

create table locatario (
                           id_pessoa int not null,
                           cpf varchar(11) not null,
                           id_apartamento int,
                           primary key (id_pessoa),
                           foreign key (id_pessoa) references pessoa(id_pessoa)
);
-- foreign key (id_apartamento) references apartamento(id_apartamento)

create table apartamento (
                             id_apartamento int auto_increment,
                             id_bloco int not null,
                             id_locatario int,
                             numero varchar(10) not null,
                             metragem double not null,
                             vagas_de_garagem int not null,
                             valor_aluguel double not null,
                             primary key (id_apartamento),
                             foreign key (id_bloco) references bloco(id_bloco),
                             foreign key (id_locatario) references locatario(id_pessoa)
);

alter table locatario add (
    foreign key (id_apartamento) references apartamento(id_apartamento)
    );

create table administrador (
                           id_pessoa int not null,
                           cnpj varchar(14) not null,
                           id_condominio int not null,
                           primary key (id_pessoa),
                           foreign key (id_pessoa) references pessoa(id_pessoa),
                           foreign key (id_condominio) references condominio(id_condominio)
);

create view pessoa_locatario as
select
    l.id_pessoa,
    l.id_apartamento,
    p.nome,
    p.telefone,
    p.email,
    l.cpf
from pessoa p
         inner join locatario l on p.id_pessoa = l.id_pessoa;

create view pessoa_administrador as
select
    a.id_pessoa,
    a.id_condominio,
    p.nome,
    p.telefone,
    p.email,
    a.cnpj
from pessoa p
         inner join administrador a on p.id_pessoa = a.id_pessoa;

create view condominio_bloco as
select
    c.id_condominio,
    c.nome as nome_condominio,
    b.id_bloco,
    b.nome as nome_bloco,
    b.andares,
    b.vagas_de_garagem
from condominio c
         inner join bloco b on c.id_condominio = b.id_condominio;

create view bloco_apartamento as
select
    b.id_bloco,
    b.nome as nome_bloco,
    a.id_apartamento,
    a.numero as numero_apartamento,
    a.id_locatario,
    a.metragem,
    a.vagas_de_garagem,
    a.valor_aluguel
from bloco b
         inner join apartamento a on b.id_bloco = a.id_bloco;
-- Cascade devido a experiência de usuário, porém não é recomendado pois desfaz as restrições criadas por uma fk;
ALTER TABLE bloco
DROP FOREIGN KEY bloco_ibfk_1,
ADD CONSTRAINT bloco_ibfk_2
FOREIGN KEY (id_condominio)
REFERENCES condominio (id_condominio)
ON DELETE CASCADE;

ALTER TABLE apartamento
DROP FOREIGN KEY apartamento_ibfk_1,
ADD CONSTRAINT apartamento_ibfk_3
FOREIGN KEY (id_bloco)
REFERENCES bloco (id_bloco)
ON DELETE CASCADE;

ALTER TABLE apartamento
DROP FOREIGN KEY apartamento_ibfk_2,
ADD CONSTRAINT apartamento_ibfk_4
FOREIGN KEY (id_locatario)
REFERENCES locatario (id_pessoa)
ON DELETE CASCADE;

ALTER TABLE locatario
DROP FOREIGN KEY locatario_ibfk_1,
ADD CONSTRAINT locatario_ibfk_3
FOREIGN KEY (id_pessoa)
REFERENCES pessoa (id_pessoa)
ON DELETE CASCADE;

ALTER TABLE locatario
DROP FOREIGN KEY locatario_ibfk_2,
ADD CONSTRAINT locatario_ibfk_4
FOREIGN KEY (id_apartamento)
REFERENCES apartamento (id_apartamento)
ON DELETE CASCADE;