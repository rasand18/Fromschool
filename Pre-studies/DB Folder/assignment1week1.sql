CREATE TABLE students (

student_id SERIAL PRIMARY KEY,
name VARCHAR(30),
age INT

);

INSERT INTO students (student_id, name, age)
VALUES(736,'John Doe',26);

UPDATE students 
SET age = 27
WHERE student_id = 736;

DELETE FROM students
WHERE student_id = 736;

DROP TABLE students;


