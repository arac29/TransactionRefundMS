insert into login (employee_id, username, password) values (100, 'alma', 'password');
insert into login (employee_id, username, password) values (101, 'rosac', 'password');
insert into login (employee_id, username, password) values (102, 'emmanuelh', 'password');
insert into login (employee_id, username, password) values (103, 'earubio', 'password');
insert into login (employee_id, username, password) values (104, 'luisr', 'password');
insert into login (employee_id, username, password) values (105, 'jessica', 'password');

insert into login (employee_id, username, password) values (200, 'eljefe', 'password');
insert into login (employee_id, username, password) values (201, 'directo2', 'password');
insert into login (employee_id, username, password) values (202, 'hannah', 'password');

insert into login (employee_id, username, password) values (300, 'head', 'password');
insert into login (employee_id, username, password) values (301, 'dephead1', 'password');

insert into login (employee_id, username, password) values (400, 'benco', 'password');
insert into login (employee_id, username, password) values (401, 'benco2', 'password');

-- ************************** create 8 employees *******************************************
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (100,'Regular', 200, 'Alma', 'Alva', '1992-05-01', '852-963-1478', 'almarosaac@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (101,'Regular', 200, 'Rosa', 'Castillo', '1972-05-01', '852-963-1478', 'aorsa@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (102,'Regular', 201, 'Emmanuel', 'Hasbro', '1992-05-01', '852-963-1478', 'ehsres@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (103,'Regular', 201, 'Evelyn', 'Rodriguez', '1974-08-01', '852-963-1478', 'earubio@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (104,'Regular', 202, 'Luis', 'Rubio', '1972-05-01', '852-963-1478', 'irubio@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (105,'Regular', 202, 'Jessica', 'Simpson', '1982-05-01', '852-963-1478', 'jessicas@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (106,'Regular', 203, 'Hannah', 'Cyrus', '1992-05-01', '852-963-1478', 'hannahcm@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (107,'Regular', 203, 'Nelly', 'Furtado', '1990-05-01', '852-963-1478', 'nfurtado@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');

--*********************** create 4 ( 200 level Direct Supervisors) *****************************
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (200,'Direct Supervisor', 300, 'Christian', 'McLean', '1992-05-01', '852-963-1478', 'cmaclan@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (201,'Direct Supervisor', 300, 'Kiara', 'Watson', '1992-05-01', '852-963-1478', 'megsacg@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 

values (202,'Direct Supervisor', 301, 'Gerald', 'Fitzgerald', '1992-05-01', '852-963-1478', 'gftadf@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (203,'Direct Supervisor', 301, 'Minnie', 'Hartxz', '1992-05-01', '852-963-1478', 'hartzmin@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');


--*********************** create 2 ( 300 level Department Head) *****************************
insert into employee (employee_id ,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (300,'Head Departement', null, 'Jeffrey',  'Nickson', '1955-01-19', '959-585-5236', 'jeffreenickson@coorp.com', '157 Street Cliffort', 'New York', 
'New York', 'US', '07087');
insert into employee (employee_id ,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (301,'Head Departement', null, 'Jack',  'Daniels', '1955-01-19', '959-585-5236', 'jjdann@coorp.com', '157 Street Cliffort', 'New York', 
'New York', 'US', '07087');

--*********************** create 2 ( 400 level BenefitCoordinators) *****************************
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (400,'Benco', null, 'Brandon', 'Gomez', '1992-05-01', '852-963-1478', 'Bencouuuatu@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');
insert into employee (employee_id,title, reports_to, first_name, last_name, date_birth, 
phone_number, email, address, city, state, country, postal_code) 
values (401,'Benco', null, 'Ashley', 'sanders', '1992-05-01', '852-963-1478', 'sandershsa@coorp.com', '187 Magnolia Street', 'New York', 
'New York', 'US', '07085');

