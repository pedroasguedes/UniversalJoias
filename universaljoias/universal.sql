/**
	Joalheria
	@author Pedro Guedes
	@version 1.0
*/
create database UniversalJoias;
use UniversalJoias;
drop database  UniversalJoias;

create table fornecedores(
idfor int primary key auto_increment,
cnpj varchar(20) not null unique,
razao varchar(40) not null,
fantasia varchar(40) not null,
fone varchar(55) not null,
cep varchar(55) not null,
endereco varchar(55) not null,
numero varchar(55) not null,
bairro varchar(55) not null,
cidade varchar(55) not null,
uf char(55) not null
);

insert into  fornecedores (cnpj,razao,fantasia,fone,cep,endereco,numero,bairro,cidade,uf)
 values ('80.012.434/0001-43','Joias Raras','Optimum Apollo','(61) 3862-2377','58805-505','Rua Gastão Medeiros Forte','43','Jardim Sorrilândia III','Sousa','PB');
 insert into  fornecedores (cnpj,razao,fantasia,fone,cep,endereco,numero,bairro,cidade,uf)
 values ('70.012.234/0001-43','AutoBots Ltda','Decepcon','(11) 99862-2377','78403-505','Rua Medeiros Forte','3','Jardim Sorrilândia I','São Paulo','SP');

select * from fornecedores inner join produtos
on fornecedores.idfor = produtos.idfor;

 select
produtos.codigo,
date_format(produtos.datacad,'%d%m%Y - %H:%i') as data_ped,
produtos.produto,
fornecedores.fantasia as fornecedor ,
fornecedores.cnpj,
fornecedores.uf
from fornecedores inner join produtos
on fornecedores.idfor = produtos.idfor;

create table produtos(
	codigo int primary key auto_increment,
    barcode varchar(255) unique,
    produto varchar(255) not null,
    descricao varchar(255) not null,
    fabricante varchar(255) not null,
    datacad timestamp default current_timestamp,
    dataval date,
    estoque int not null,
    estoquemin int not null,
    unidade varchar(255) not null,
    custo decimal(10,2) not null,
    localizacao varchar(255) ,
    lucro decimal(10,2),
    venda decimal(10,2),
    idfor int not null,
	foreign key (idfor) references fornecedores (idfor)
    );
    	insert into produtos(barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
    values ('1234560','Brinco de Pérolas Classic','Pérolas Negras','Nagalli','23900523','90','4','UN','Cofre 4',5000,100,3000,1);
    insert into  produtos(barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
    values  ('126549870','Brinco de Pérolas Gota Long','Pérolas Brancas','Nagalli','23900523','9','10','UN','Cofre 5',7000,70,4000.00,2);
    insert into produtos(barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
    values ('123441234','Anel Colors OX','Ouro Branco','Nagalli','23900513','230','23','UN','Cofre 6',3000,60,1000,1);
    insert into  produtos(barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
    values  ('53214324','Anel Love Heart','Ametista','Nagalli','23900513','500','50','UN','Cofre 7',8000,30,6000,1);
	insert into  produtos(barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
    values ('5743459',' Anel Prata Espinélios e Topázios London','Rubi','Nagalli','20200513','47','100','UN','Cofre 9',1200,100,1900,2);

select * from produtos;
  
select codigo as código,
     produto,
     date_format(dataval,'%d/%m/%Y') as data_validade,
     estoque,
     estoquemin as estoque_mínimo
     from produtos where estoque < estoquemin;
	


create table cliente (
 idcli int primary key auto_increment,
 nome varchar (255) not null,
 fone varchar(255) not null,
 cpf varchar(255) unique,
email varchar(255),
marketing varchar(255) not null,
cep varchar(255),
endereco varchar(255),
bairro varchar(255),
numero varchar(255),
complemento varchar(255),
cidade varchar(255),
uf char(2)
);
insert into  cliente(nome,fone,cpf,email,marketing)
 values ('Marcos Vinicius Lucas Filipe Viana','(12) 3737-3469','103.061.809-79','marcosviniciusviana@mixfmmanaus.com.br','Sim');   
 insert into  cliente(nome,fone,cpf,email,marketing)
 values (' Vinicius Lucas Filipe Viana','(15) 0937-3469','103.0621.809-79','sviniciusviana@mixfmmanaus.com.br','Não');

 select * from cliente where marketing='Sim';

create table usuarios (
	iduser int primary key auto_increment,
    usuario varchar(10) not null,
    login varchar(25) not null unique,
    senha varchar(25) not null,
    perfil varchar(25) not null
);

describe usuarios;

insert into usuarios (usuario,login,senha,perfil)
values ('administrador','admin',md5('admin'),'admin');

insert into usuarios (usuario,login,senha,perfil)
values ('pamela','pam',md5('123456'),'user');

select * from usuarios;


create table pedidos (
pedido int primary key auto_increment,
dataped timestamp default current_timestamp,
total decimal(10,2),
idcli int not null,
foreign key (idcli) references cliente(idcli)
);

insert into pedidos(idcli) values(2);
select * from pedidos;
select
pedidos.pedido,
date_format(pedidos.dataped, '%d%m%Y - %H:%i') as data_ped,
cliente.nome as cliente,
cliente.fone
from pedidos inner join cliente
on pedidos.idcli = cliente.idcli;


create table carrinho (
	pedido int not null,
	codigo int not null,
	quantidade int not null,
    foreign key(pedido) references pedidos(pedido),
    foreign key(codigo) references produtos(codigo)
);
insert into carrinho values (1,5,10);
insert into carrinho values (2,3,7);
select * from carrinho;

select pedidos.pedido,
carrinho.codigo as código,
produtos.produto,
carrinho.quantidade,
produtos.venda,
produtos.venda * carrinho.quantidade as sub_total
from (carrinho inner join pedidos on carrinho.pedido =
pedidos.pedido)
inner join produtos on carrinho.codigo = produtos.codigo;

select sum(produtos.venda * carrinho.quantidade) as total
from carrinho inner join produtos on carrinho.codigo = produtos.codigo;


update carrinho
inner join produtos
on carrinho.codigo = produtos.codigo
set produtos.estoque = produtos.estoque - carrinho.quantidade
where carrinho.quantidade > 0;







