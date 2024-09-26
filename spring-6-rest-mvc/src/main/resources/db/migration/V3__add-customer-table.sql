create table customer (
                      version integer,
                      created_date datetime(6),
                      update_date datetime(6),
                      id varchar(36) not null,
                      name varchar(36) not null,
                      email varchar(255) not null,
                      primary key (id)
) engine=InnoDB;