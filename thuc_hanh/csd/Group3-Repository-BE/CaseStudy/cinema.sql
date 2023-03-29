drop schema cinema;
create schema cinema;
use cinema;
create table movie_type(
id int primary key auto_increment,
name varchar(50)
);
create table movie(
id int primary key auto_increment,
name varchar(50),
actor varchar(50),
director varchar(50),
content varchar(50),
id_movie_type int,
foreign key (id_movie_type) references movie_type(id)
);
create table customer_type(
id int primary key auto_increment,
name varchar(50)
);
create table customer(
id int primary key auto_increment,
name varchar(50),
gender varchar(50),
age varchar(50),
phone varchar(50),
address varchar(50),
id_customer_type int,
foreign key (id_customer_type) references customer_type(id)
);
create table employee_type(
id int primary key auto_increment,
name varchar(50)
);
create table employee(
id int primary key auto_increment,
name varchar(50),
gender varchar(50),
age varchar(50),
phone varchar(50),
address varchar(50),
wage varchar(50),
id_employee_type int,
foreign key (id_employee_type) references employee_type(id)
);
create table service_type(
id int primary key auto_increment,
name varchar(50)
);
create table service(
id int primary key auto_increment,
name varchar(50),
start_date datetime,
end_date datetime,
price varchar(50),
id_service_type int,
foreign key (id_service_type) references service_type(id)
);
create table branch(
id int primary key auto_increment,
name varchar(50)
);
create table cinema(
id int primary key auto_increment,
name varchar(50),
address varchar(50),
id_branch int,
foreign key (id_branch) references branch(id)
);
create table ticket_type(
id int primary key auto_increment,
name varchar(50)
);
create table show_time(
id int primary key auto_increment,
time varchar(50)
);
create table ticket(
id int primary key auto_increment,
name varchar(50),
quantity int,
price varchar(50),
booking_time datetime,
id_ticket_type int,
id_movie int,
id_customer int,
id_employee int,
id_service int,
id_cinema int,
id_show_time int,
foreign key (id_movie) references movie(id),
foreign key (id_customer) references customer(id),
foreign key (id_employee) references employee(id),
foreign key (id_service) references service(id),
foreign key (id_cinema) references cinema(id),
foreign key (id_ticket_type) references ticket_type(id),
foreign key (id_show_time) references show_time(id)
);

