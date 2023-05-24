create table task (
	id bigint not null auto_increment,
    nome varchar(255) not null,
    data datetime not null,

    primary key (id)
);