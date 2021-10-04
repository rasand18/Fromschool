CREATE TABLE tacoFriday (

food_name VARCHAR(30) PRIMARY KEY,
food_type VARCHAR(30),
food_rating INT NOT NULL,
price INT NOT NULL

);

INSERT INTO tacoFriday (food_name,food_type,food_rating,price)
VALUES
("Corn","Vegetable",3,20),
("Tomato","Vegetable",1,10),
("Cucumber","Vegetable",3,15),
("Onion","Vegetable",4,6),
("Mince","Meat",5,50),
("Tortilla","Container",5,13),
("Shell","Container",2,15),
("Creme fraiche","Topping",5,15),
("Taco sauce","Topping",5,17),
("Coca cola","Beverage",5,20);

SELECT * FROM tacoFriday tf ;

SELECT DISTINCT food_type FROM tacoFriday
ORDER BY food_type DESC

SELECT * FROM tacoFriday tf 
WHERE price > 12;

SELECT * FROM tacoFriday tf
WHERE price > 4
AND (food_rating=1 OR food_rating=4);

SELECT * FROM tacoFriday tf 
WHERE price >10
and food_rating BETWEEN 1 AND 4;

SELECT * FROM tacoFriday tf 
WHERE price >10
AND food_rating IN (2,3,4);

SELECT 
	food_name,food_type,price
FROM tacoFriday;

SELECT food_name,food_type,price FROM tacoFriday tf 
ORDER BY price DESC
LIMIT 3;

SELECT * FROM tacoFriday tf 
WHERE food_name LIKE "T%";




