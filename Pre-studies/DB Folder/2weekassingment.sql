-- Assignment 1:
CREATE TABLE tacoFriday (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	food_name TEXT,
	food_type TEXT,
	food_rating INTEGER CHECK(food_rating<=5 and food_rating>=1),
	food_price INTEGER NOT NULL 
);

-- Assignment 2:
INSERT INTO 
	tacoFriday (food_name, food_type, food_rating, food_price)
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

-- Assignment 3:
SELECT DISTINCT food_type 
FROM tacoFriday
ORDER BY food_type DESC;

-- Assignment 4:
SELECT * 
FROM tacoFriday
WHERE food_price > 12;

-- Assignment 5:
SELECT * 
FROM tacoFriday
WHERE food_price > 4
AND (food_rating=1 OR food_rating=4);

-- Assignment 6:
SELECT * 
FROM tacofriday
WHERE food_price > 4
AND food_rating BETWEEN 1 AND 4;

-- Assignment 6:
SELECT * 
FROM tacofriday
WHERE food_price > 4
AND food_rating IN (1,2,3,4);

-- Assignment 7:
SELECT food_name AS "name", food_type AS "type", food_price AS "price" 
FROM tacoFriday;

-- Assignment 8:
SELECT food_name,food_type,food_price 
FROM tacofriday
ORDER BY food_price DESC 
LIMIT 3;

-- Assignment 9:
SELECT * 
FROM tacofriday
WHERE food_name LIKE "T%";



