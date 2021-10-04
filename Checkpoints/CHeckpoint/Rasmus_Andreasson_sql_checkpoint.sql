--1. Create a table named employees with columns representing:An id as the primary key
-- (should be auto-assigned and incremented automatically)A name of the employee as a varchar,
-- which cannot be null - You deide the length A salary as an int, which cannot be null or negative Date 
--of hire as the type date, which cannot be nullAn address with a suitable length

create table employees(
employee_id serial primary key,
employee_name varchar(40) not null,
salary int not null check(salary >= 0),
date_of_hire date not null, 
address varchar(30) null
);

select * from employees e ;

-- 2. Insert data into the table and remember to insert different and meaningfull values. NB! Please keep in
-- the mind the fields, which can/cannot be null and make sure to include all cases. You don't have to put
-- much data in here, but more data will make it easier for you to test out the queries in the next section.

insert into employees(employee_name,salary,date_of_hire,address) 
values
	('Calle Johansson',2000,'2014-03-01','Lillebyvägen 24'),
	('Pelle Andreasson',1500,'2014-04-05',null),
	('Johan Karlsson',2500,'2015-09-07','Röds sörrgård 5'),
	('Inger Bengtsson',500,'2015-05-01','Bolmensgatan 7'),
	('Karl Karlsson',600,'2015-09-07','Bottnevägen 4');

-- 3. After having inserted data, fetch the data to view the newly updated table. Does it look right?
select * from employees e ;

-- DQL

-- 1.  Select the rows, where the address in null

select * from employees e 
where address is null;

-- 2. Select the rows, where the salary is greater than 1000
select * from employees e 
where salary > 1000;

-- 3. Select the rows, where the address in not null
select * from employees e 
where address is not null;

-- 4. Select everything from the table where the salary is greater than a constant (which you can choose) and
-- order the output descendingly order with regards to the hire date

select * from employees e 
where salary > 1200
order by date_of_hire desc;

-- 5. Print out each year together with a count of how many people were hired in that year

select extract (year from date_of_hire)as year, 
count(date_of_hire) as hired_in_that_year
from employees e
group by year;
 
-- 6. Select all rows in the table that has a salary greater than the average salary of everyone. Use a subquery
-- to extract the average salary
select * from employees e2 
where salary >(
select avg(salary) from employees e );

-- 7. For each employee list their name and salary together with the average salary for all employees hired in
-- the same year as them. So, if an employee is hired in 2020, we want their name, salary and the average
-- salary of all employees hired in 2020. Have the output ordered alphabetically

select employee_name, salary,
extract (year from date_of_hire)as year, 
avg(salary) over (partition by extract (year from date_of_hire))
from employees e
order by employee_name;

-- 8. List the summed salary grouped on month, year and total for hire date. That means we want a sum of
-- all salaries for each (year, month), (year) and () combinations. Consider which GROUPING SETS method
-- is best suited for this type of query and use that.

select 
extract (year from date_of_hire) as year,
extract (month from date_of_hire) as month,
sum(salary)
from employees e
group by rollup (year,month);


-- 9. Delete the rows in the table that have a null address value

delete from employees 
where address is null;


