use footballmanager;
create table user(
                     id int auto_increment primary key ,
                     fullname varchar(255) not null ,
                     email varchar(255) not null,
                     password varchar(255) not null
);
create table role(
                     id int auto_increment primary key ,
                     id_user int not null ,
                     role varchar(255) not null,
                     foreign key (id_user) references user(id)
);
create table player(
                       id int auto_increment primary key ,
                       id_user int not null ,
                       namePlayer varchar(255) not null ,
                       bornYear int not null ,
                       address varchar(255) not null ,
                       position varchar(255) not null ,
                       salary double not null ,
                       status varchar(255) not null,
                       image varchar(255) not null ,
                       foreign key (id_user) references user(id)

);
create table playerStats(
                            id int auto_increment primary key ,
                            id_player int not null ,
                            height double not null,
                            weight double not null ,
                            bmiIndex double not null ,
                            formIndex int not null ,
                            foreign key (id_player) references player(id)
);
create table weekofplayer(
                             id int auto_increment primary key ,
                             id_player int not null ,
                             week int not null ,
                             bonus double not null ,
                             playtimeofWeek int not null,
                             preformedSalary double not null ,
                             foreign key (id_player) references player(id)

);
create table coach(
                      id int auto_increment primary key ,
                      id_user int not null,
                      nameCoach varchar(255) not null ,
                      bornYear int not null ,
                      address varchar(255) not null ,
                      salary double not null,
                      foreign key (id_user) references user(id)

);
create table weekofCoach(
                            id int auto_increment primary key ,
                            id_coach int not null ,
                            week int not null ,
                            bonus double not null ,
                            foreign key (id_coach) references coach(id)
);