CREATE TABLE tacofriday (
food_name TEXT,
food_type TEXT,
food_rating INTEGER CHECK(food_rating<=5 and food_rating>=1),
food_price INTEGER NOT NULL 
);

INSERT INTO tacofriday (food_name,food_type,food_rating,food_price)
VALUES
("Corn","Vegetable",3,20),
("Tomato","Vegetable",1,10),
("Cucumber","Vegetable",3,15),
("Onion","Vegetable",4,6),
("Mince","Meat",5,50),
("Tortilla","Container",5,13),
("Shell",null,2,15),
("Creme fraiche","Topping",5,15),
("Taco sauce","Topping",5,17),
("Coca cola","Beverage",5,20);

--1. Write a SQL query that counts the total number of rows.
SELECT COUNT(*) FROM tacofriday; 

--2. Write a SQL query that counts the number of non-null food types
SELECT COUNT(*) FROM tacofriday
WHERE food_type IS NOT NULL;

/* 3.Write a SQL query that sums the prices of each food type. 
   You should output the food type and the sum of the prices as the only two columns.
   Order by the food type the most expensive summed price.
*/
SELECT food_type, SUM(food_price) AS "Summery of food price"FROM tacofriday
WHERE food_type IS NOT NULL
GROUP BY food_type
ORDER BY SUM(food_price) DESC;

/* 
	4. Write a SQL query that returns the average price of all combinations of food type and rating 
	(Hint: You must ORDER BY two columns together). Make the output be columns of food type,
	rating and average price and have them ordered alphabetically by food type followed by rating starting from 5 down to 1.
*/
SELECT food_type,food_rating, AVG(food_price)FROM tacofriday
WHERE food_type IS NOT NULL
GROUP BY food_type,food_rating 
ORDER BY food_rating DESC;

--5. Write a SQL query that returns the least expensive item for each rating.
SELECT food_name,food_rating,food_price FROM tacofriday
GROUP BY food_rating
HAVING MIN(food_price) 
ORDER BY food_rating;

/* 6. Write a SQL query that returns the food type and the count of foods in that category,
 	  but only for groups with more than one item in them.
 */
SELECT food_type, COUNT(food_type) AS "Count of foods" FROM tacofriday tf
WHERE food_type IS NOT NULL 
GROUP By food_type
HAVING COUNT(food_type)> 1;














