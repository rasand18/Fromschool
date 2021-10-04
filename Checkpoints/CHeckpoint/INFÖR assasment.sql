-- 1. List the first name of all actors.
select first_name from * actor a ;

-- 2. List all the data from the customer table.

select * from customer c ;

-- 3. List all unique actor first names.

select distinct first_name from actor a ;

-- 4. List actors first names in reversed alphabetical order

select * from actor a 
order by first_name desc;

-- 5. Count how many movies have been rented out in total.

select count(*) from rental r ;

-- 6. Find the first movie that was rented out.

select min(rental_date) from rental r ;

-- 7. List the 10 payments with highest amount.

select * from payment p 
order by amount desc 
limit 10;

-- FROM

-- 1. Find the firstname and lastname of the customer that lives in York.

select first_name, last_name from customer c 
where 
	address_id in(
select
	address_id from address a 
where 
	city_id in(
select
	city_id from city c 
where city = 'York'));

-- 2. 2. List the title of all films that are in the category 'Comedy'
select title from film f 
where 
	film_id in(
select 
	film_id from film_category fc 
where 
	category_id in (
select
	category_id from category c
where name = 'Comedy'));

 -- 3. Create a Cartesian product of table payment and rental.

select * from payment p 
cross join rental r ;

-- 4. Count the number of rows in the Cartesian product of table payment and rental. 
-- What does this tell youabout Cartesian products?

select count(*) from payment p 
cross join rental r ;

-- 5. 5. Cross join film and actor, listing film title and actor name

select f.title, a.first_name, a.last_name from film f 
cross join actor a ;

-- 6. List first name, last name and address and district of all customers

select first_name, last_name, a.address, a.district from customer c 
join address a using(address_id);

-- 7. List film title and category name of all films

select title, c.name from film f 
join film_category fc using(film_id)
join category c using(category_id);

-- 8. Join film and actor, listing film title and actor name. But list only the combinations where an actorappears in a movie.

select title, a.first_name, a.last_name from film f 
join film_actor fa using(film_id)
join actor a using(actor_id);

-- 9. . List all actors with what categories they have films in. If an actor appears in multiple films in the samecategory,
--  that category should only be listed once.

select first_name, last_name, c.name from actor a 
join film_actor fa using(actor_id)
join film f using(film_id)
join film_category fc using(film_id)
join category c using(category_id);

-- LEFT

-- 10. Use left join to list the cities with the corresponding addresses to each of the cities.

select c.city, a.address from city c 
left join address a on c.city_id = a.city_id;

-- 11. Use right join to list inventory of each film. List inventory id, film id and film title

select inventory_id, f.film_id, f.title from inventory i 
right join film f on i.film_id = f.film_id
where i.film_id is null;

-- 1. List a full join between film and inventory

select * from film f 
full join inventory i on i.film_id = f.film_id ;

-- 2. List the first rental date of each customer id

select customer_id, min(rental_date) from rental r 
group by customer_id 
order by min ;

-- 3. List all films and their category, who has category with name longer than 8 characters.
select title from film f 
where 
	film_id in(
select film_id from film_category fc 
where 
	category_id in(
select c.category_id from category c 
where 
	char_length("name")>8

	));

-- WHERE

-- 1. List all actors first and last name whose first name is Christian

select first_name, last_name from actor a 
where first_name ='Christian';

-- 2.2. List all payments where the amount is greater than 8

select * from payment p 
where amount >8;

-- 3. 3. List all payments where the amount is between 5 and 6

select * from payment p 
where amount between 5 and 6;

-- 3. 4. List all payments where the amount is less than 1 or greater than 10

select * from payment p 
where amount not between 1 and 10;

-- 5. List all films and actors of the films where the replacement cost is higher than 25
select first_name, last_name from actor a 
where actor_id in(
select actor_id from film_actor fa 
where film_id in(
select film_id from film f 
where replacement_cost > 25));

-- SUB 

-- List the 10 payments with highest amount. Ordered from lowest amount to highest.
select * from(
select payment_id, max(amount) from payment p 
group by payment_id
order by max desc
limit 10) as a1
order by max;


-- 11. List all customers who have made at least one payment with amount 0. Using the EXISTS operator

select distinct customer_id from customer c 
where exists(
select customer_id from payment p 
where amount = 0);




