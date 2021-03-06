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
SELECT * FROM footballmanager.weekofplayer;
select player.namePlayer ,week,(player.salary+ preformedSalary*playtimeofWeek+bonus) as salaryofWeek from player join weekofplayer on player.id= weekofplayer.id_player where id_player = 1  group by weekofplayer.week;
select coach.nameCoach, week,( coach.salary + bonus) as salaryofWeek from coach join weekofcoach on coach.id = weekofcoach.id_coach where id_coach= 1 group by weekofcoach.week;
select namePlayer, address, bornYear, player.position, salary, status from player where id =1;
select height,weight,bmiIndex,formIndex from playerstats where  id =1;
