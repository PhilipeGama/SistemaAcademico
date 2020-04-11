create schema sistemaacademico;

use sistemaacademico;

create table aluno(
alucodigo int not null auto_increment,
alunome varchar(80) not null,
alusexo char(1) not null,
primary key(alucodigo)
);

insert into aluno(alunome,alusexo) values ('pedro','M'),
											('maria','F');


select *from aluno;

create table curso(
curcodigo int not null auto_increment,
cursigla varchar(20) not null,
curdescricao varchar(80) not null,
primary key(curcodigo)
);



insert into curso(cursigla,curdescricao) values ('TADS','Tecnologia Analise e Desenvolvimento de Sistema'),
											('FIS','Fisica');


select *from curso;


create table disciplina(
disccodigo int not null auto_increment,
discsigla varchar(20) not null,
discnome varchar(80) not null,
primary key(disccodigo)
);


insert into disciplina(discsigla,discnome) values
												('FISI','FISICA I'),
                                                ('CALCI','CALCULO I');

select *from disciplina;



create table professor(
procodigo int not null auto_increment,
pronome varchar(80) not null,
proformacao varchar(80) not null,
primary key(procodigo)
);

insert into professor(pronome,proformacao) values ('João','Fisica'),
												  ('Philipe Gama','TADS'),
                                                  ('John','Cowboy');

select *from professor;


create table turma(
turcodigo int not null auto_increment,
turnome varchar(80) not null,
primary key(turcodigo)
);


insert into turma(turnome) values ('TADS21'),
									('TADS22'),
                                    ('FIS22');
                                    
                                    
create table administrador(
admcodigo int not null auto_increment,
admlogin varchar(80)  not null,
admsenha varchar(80) not null,
primary key(admcodigo)
);   

drop table administrador;                                 




insert into administrador(admlogin,admsenha) values ('admin','123');									
