-- Create a new branch called f-sql
-- Create a file called Sakila_Project.sql

-- Sakila Database

-- Write a SQL statement for each of the following. 

-- 1. Get 10 cities in descending alphabetical order.

select * from sakila.city 
order by city desc 
limit 10;

-- 2. Get all films with "airplane" in the title.

select * from sakila.film
where title like '%airplane%';

-- 3. Get the highest payment amount.

select max(amount) from sakila.payment;

-- 4. Get the number of records in the customer table for store id #1.

select count(*) from sakila.customer 
where store_id = 1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"

select * from sakila.payment as p
inner join sakila.customer as c
using ( customer_id )
where c.email = 'NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.

-- returns a table
select * from sakila.film_list 
where actors like '%BOB FAWCETT%';

-- OR:

-- returns a string
select film_info from sakila.actor_info 
where first_name = 'bob' 
and last_name = 'fawcett';

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 

set @p_film_count = 0;
call sakila.film_in_stock(
	(select film_id from sakila.film where title = 'Alien Center'),
	 2, 
	 @p_film_count
 );
select @p_film_count;

-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.) 

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 

-- 10. Delete the new store. 

-- 11. Using one SQL statement, get how many films are there in each rating category.

select rating, count(*)
from sakila.film f
group by rating;

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.

select c.first_name, c.last_name, spent
from sakila.customer as c
join
	(select sum(amount) as spent, customer_id
	from sakila.payment as p
	group by customer_id
      order by spent desc
	limit 3) as big_spenders
using (customer_id);

-- 13. Get all movies rented by the customer who spent the most. (Hint: This will either require nested queries, or more than two joins. one approach is much shorter than the other.)

select title 
from sakila.film
join sakila.inventory using ( film_id )
join sakila.rental using ( inventory_id )
join
	(select sum(amount) as spent, customer_id
	from sakila.payment
	group by customer_id
	order by spent desc
	limit 1) as big_spender
using (customer_id);

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.

select c.first_name, c.last_name, spent
from sakila.customer as c
join (
    select sum(amount) as spent, customer_id
	from sakila.payment as p
	group by customer_id
    ) as big_spenders
using ( customer_id )
where spent > 150;

-- Do not hard code IDs.

-- https://dev.mysql.com/doc/sakila/en/sakila-introduction.html

-- Schema Diagram:
-- https://www.jooq.org/sakila#:~:text=The%20Sakila%20database%20is%20a,films%2C%20stores%2C%20and%20rentals.
