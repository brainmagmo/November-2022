-- Create a new branch called f-sql
-- Create a file called Sakila_Project.sql

-- Sakila Database

-- Write a SQL statement for each of the following. 

-- 1. Get 10 cities in descending alphabetical order.

select * 
from sakila.city 
order by city desc 
limit 10;

-- 2. Get all films with "airplane" in the title.

select * 
from sakila.film
where title like '%airplane%';

-- 3. Get the highest payment amount.

select max(amount) 
from sakila.payment;

-- 4. Get the number of records in the customer table for store id #1.

select count(*) 
from sakila.customer 
where store_id = 1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"

select * 
from sakila.payment p
join sakila.customer c
using ( customer_id )
where c.email = 'NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.

-- EITHER:
select * 
from sakila.film_list 
where actors 
like '%BOB FAWCETT%';
-- returns a table

-- OR:
select film_info 
from sakila.actor_info 
where first_name = 'bob' 
and last_name = 'fawcett';
-- returns a string

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 

set @var = 0;
call sakila.film_in_stock(
    (
        select film_id 
        from sakila.film 
        where title = 'Alien Center'
    ),
     2, 
     @var
 );

-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.) 

start transaction;

set @address = (
    select address_id 
    from sakila.address
    where address_id not in (
        select address_id 
        from sakila.store
    ) 
    limit 1
);

insert into sakila.staff(
    first_name,    
    last_name,
    address_id, 
    email,
    store_id,
    username, 
    password
    ) values (
    'trevor',
    'kleinstuber',
    @address, 
    'tklein@email.site',
    (
        select store_id 
        from sakila.store 
        limit 1
    ),
    'tklein', 
    'very secure password'
    );
    
set @staff = LAST_INSERT_ID();

insert into sakila.store(
    manager_staff_id,
    address_id
    ) values (
    @staff, 
    @address
    );

set @mystore = LAST_INSERT_ID();

update sakila.staff
set store_id = @mystore
where staff_id = @staff;

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 

update sakila.store
set last_update = now()
where store_id = @mystore;

-- 10. Delete the new store. 

update sakila.staff
set store_id = (
    select store_id 
    from sakila.store 
    where store_id != @mystore 
    limit 1
    )
where staff_id = @staff;

delete from sakila.store
where store_id = @mystore;

rollback;

-- 11. Using one SQL statement, get how many films are there in each rating category.

select rating, count(*)
from sakila.film f
group by rating;

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.

select c.first_name, c.last_name, spent
from sakila.customer as c
join (
    select sum(amount) as spent, customer_id
    from sakila.payment as p
    group by customer_id
    order by spent desc
    limit 3
    )
as big_spenders using ( customer_id );

-- 13. Get all movies rented by the customer who spent the most. (Hint: This will either require nested queries, or more than two joins. one approach is much shorter than the other.)

select title 
from sakila.film
join sakila.inventory using ( film_id )
join sakila.rental using ( inventory_id )
join (
    select sum(amount) as spent, customer_id
    from sakila.payment
    group by customer_id
    order by spent desc
    limit 1
    ) 
as big_spender using ( customer_id );

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.

select c.first_name, c.last_name, spent
from sakila.customer as c
join (
    select sum(amount) as spent, customer_id
    from sakila.payment as p
    group by customer_id
    )
as big_spenders using ( customer_id )
where spent > 150;

-- 12 through 14 using views

create view sakila.customer_spending as
select sum(p.amount) as spent, c.first_name, c.last_name, customer_id
from sakila.customer c
join sakila.payment p
using ( customer_id )
group by customer_id;

select first_name, last_name, spent
from sakila.customer_spending
order by spent desc
limit 3;

select f.title 
from sakila.film f
join sakila.inventory i using ( film_id )
join sakila.rental r using ( inventory_id )
join ( 
    select spent, customer_id
    from sakila.customer_spending 
    order by spent desc
    limit 1
    )
as big_spender using ( customer_id );

select first_name, last_name, spent
from sakila.customer_spending 
where spent > 150;

drop view sakila.customer_spending;

-- Do not hard code IDs.

-- https://dev.mysql.com/doc/sakila/en/sakila-introduction.html

-- Schema Diagram:
-- https://www.jooq.org/sakila#:~:text=The%20Sakila%20database%20is%20a,films%2C%20stores%2C%20and%20rentals.
