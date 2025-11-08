
#1 Compute the set of all products. The result will contain only the column with the product name.
select product_name from products.products;

#2 Compute the set of products whose names begin with 'c'.
select product_name from products.products
where product_name like 'c%';

#3 Compute the set of products that contain the text 'par'.
select product_name from products.products
where product_name like '%par%';

#4 Compute the set of products that contain the text 'fata'.
select product_name from products.products
where product_name like '%fata%';

#5 Are there products that do not have a defined type?
select * from products.products
where type_id is null;

#6 Are there products that do not have measurement unit?
select * from products.products
where mu_id is null;

#7 Are there products that have a defined type but do not have a defined unit of measurement?
select * from products.products
where type_id is not null
and mu_id is null;

#8 Are there products that have both undefined type and unit of measurement?
select * from products.products
where type_id is null
and mu_id is null;

#9 Display the list of products that also have the defined type and unit of measurement.
select * from products.products
where type_id is not null
and mu_id is not null;

#10 Compute the set of distinct product names. The result will contain the Denumire (it means Name) field, sorted by Denumire.
select distinct(product_name) as denumire from products.products
order by product_name;

#11 Compute the set of products for which the type and unit of measurement are known. As a result, the fields DenProdus, CodBare will appear. The results should be ordered by DenProdus.
select product_name as DenProdus, barcode as CodBare from products.products
where type_id is not null
and mu_id is not null
order by product_name;

#12 Compute the set of products together with the type and unit of measurement, for those products that have the known type and unit of measurement, respectively.
SELECT p.product_id, p.product_name, t.type_name, m.short_name
FROM products.products p
 JOIN products.product_types t ON p.type_id = t.product_type_id
 JOIN products.measurement_units m ON p.mu_id = m.mu_id;

#13 Compute the set of products together with the supplier who supplies them and the price increased by 16% (the column will be called PretNou).
select p.product_name,
    s.price,
    ROUND(s.price * 1.16, 2) AS "PretNou"
from products.products p
 JOIN products.supplies s ON p.product_id = s.product_id
order by p.product_id, s.supply_date

#14 Find out the multitude of all suppliers that supply products whose name starts with the letter 'g'. The result will contain the columns Furnizor (where the name of the supplier will be found, written in capital letters) and Produs (where the name of the product will be found, written in small letters).
Hint: Use the ucase and lcase functions.
select UPPER(CONCAT(p.last_name, ' ', p.first_name)) AS Furnizor,
lower(pr.product_name) as Produs 
from products.supplies s
 join products.people p on s.supplier_id = p.person_id
 join products.products pr on s.product_id = pr.product_id
where p.last_name like 'G%';

#15 Compute the set of products that are sold per piece (the unit of measure is "buc").
select p.product_name, m.short_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
where m.short_name ='buc';

#16 Compute the set of products that are sold per kg.
select p.product_name, m.short_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
where m.short_name ='kg';

#17 Compute the set of 'racoritare' products that are sold by the piece.
select p.product_name, m.short_name, t.type_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
 join products.product_types t on p.type_id = t.product_type_id
where type_name ='racoritoare'
and short_name = 'buc';

#18 Compute the set of 'soft' products that are not sold by the piece.
select p.product_name, m.short_name, t.type_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
 join products.product_types t on p.type_id = t.product_type_id
where type_name ='racoritoare'
and short_name != 'buc';

#19 Compute the set of soft drinks, vegetables, fruits, greens or meat. (Hint: Use the IN operator)
select p.product_name, m.short_name, t.type_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
 join products.product_types t on p.type_id = t.product_type_id
where type_name in ('racoritoare', 'verdeturi', 'legume-fructe', 'carne');

#20 Compute the set of products that are provided by the supplier with the name Metro and are sold per kilogram.
select p.product_name, m.short_name as measurement_unit, peo.last_name, peo.first_name
from products.products p
 join products.measurement_units m on p.mu_id =m.mu_id
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id
where short_name = 'kg' 
and last_name = 'Metro';

#21 Compute the set of products together with their suppliers only for those products for which the price at which they are supplied is known. The results should be displayed ordered by supplier.
select p.product_name,
CONCAT(peo.last_name, ' ', peo.first_name) as Supplier
from products.products p
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id
where price is not null
order by supplier_id;

#22 Compute the set of products together with their suppliers and the price at which they are supplied and to display them ordered by ascending supplier and by decreasing price.
select p.product_name,
CONCAT(peo.last_name, ' ', peo.first_name) as Supplier,
s.price
from products.products p
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id
order by supplier_id, price desc

#23 Compute the set of products together with their suppliers and the price at which they are supplied, for the products supplied at a price higher than 10000. The results should be ordered by the name of the supplier.
select p.product_name,
CONCAT(peo.last_name, ' ', peo.first_name) as Supplier,
s.price
from products.products p
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id
where s.price > 10000
order by peo.last_name;

#24 Compute the set of products that have the supply price between 100 and 2000.
select p.product_name, s.price
from products.products p
 join products.supplies s on p.product_id = s.product_id
where s.price between 100 and 2000;

#25 Write a query that displays the list of products, in ascending order by name, along with the price at which they are provided by each supplier and the value of VAT for each product (say VAT is 10% of the Price), as well as a column PriceTotal (= Price + VAT).
select p.product_name,
CONCAT(peo.last_name, ' ', peo.first_name) as Supplier,
s.price as initial_price,
round(s.price /10, 2) as price_VAT,
round(s.price /10, 2) + price as Price_Total
from products.products p
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id
order by product_name;

#26 Write a query to display today's date. The column will be called Today.
SELECT CURRENT_DATE AS "Today";

#27 select Using the concatenation function, display a column with the text "Supplier X supplies product Y '.
CONCAT('Supplier ', peo.last_name,' ', peo.first_name, ' supplies product ', p.product_name) as text
from products.products p
 join products.supplies s on p.product_id = s.product_id
 join products.people peo on s.supplier_id = peo.person_id;

#28 Find out all the products whose names end in "a".
select * from products.products p
where product_name like '%a';

#29 Find all the products in the name of which the letter "a" appears twice.
select * from products.products p
where product_name like '%a%a%';

#30 Compute the set of products and their type, regardless of whether or not they have the defined type (for those that do not have the defined type, the field should remain blank). The results should be ordered by product name.
Hint. Use an external join.
select p.product_name,
COALESCE(t.type_name, '')
from products.products p
left outer join products.product_types t on p.product_id = t.product_type_id
order by product_name;

#31 Compute the multitude of all persons together with the products provided by them (if any - if not, let the field remain empty); the results should be displayed in order of the suppliers name. Use an external join.
select CONCAT(peo.last_name, ' ', peo.first_name) as Supplier,
p.product_name
from products.products p
left outer join products.supplies s on p.product_id = s.product_id
left outer join products.people peo on s.supplier_id = peo.person_id
order by last_name;

#32 Add the Supply Date column to the SUPPLIES list, of type DateTime, not mandatory to fill in. Add the validation rule: Date of Supply> # 1/1/2014 #. Fill in the information in the table, adding calendar data, so that you have empty answers to the questions below.
ALTER TABLE supplies ADD CONSTRAINT chk_supply_date
CHECK (supply_date > '2014-01-01');

#33 For each line in SUPPLIES, calculate the number of months from the Date on the line until today.
SELECT supply_date,
EXTRACT(YEAR FROM AGE(CURRENT_DATE, supply_date)) * 12 + EXTRACT(MONTH FROM AGE(CURRENT_DATE, supply_date)
AS months_since
FROM products.supplies;

#34 Show all products for which Data is missing in the SUPPLIES relationship.
SELECT product_name, supply_date
FROM products.products p
left join products.supplies s on p.product_id = s.product_id
where supply_date is null;


#35 Select the set of products provided by the supplier 'metro', after the date of #1/1/2015 #.
SELECT *
FROM products.products p
join products.supplies s on p.product_id = s.product_id
join products.people peo on s.supplier_id = peo.person_id
where supply_date > '2015-01-01' and last_name = 'metro';

#36 Select the set of products supplied in the last 6 months. Hint: use the DateDiff function, with the difference expressed in months, between the delivery date and the current time (Now ()).
SELECT p.product_id, p.product_name, s.supply_date
FROM products.products p
JOIN products.supplies s ON p.product_id = s.product_id
WHERE s.supply_date >= NOW() - INTERVAL '6 months';

#37 Select the set of suppliers that did NOT supply products after # 1/1/2015 #.
SELECT CONCAT(peo.last_name, ' ', peo.first_name) as Supplier,
supply_date
FROM products.supplies s
JOIN products.people peo ON s.supplier_id = peo.person_id
where supply_date < '2015-01-01';

#38 Write a query in which you display the calendar month for each product provided, in the vegetable-fruit category.
select TO_CHAR(s.supply_date, 'Month') AS supply_month
from products.products p
join products.product_types t on p.type_id = t.product_type_id
join products.supplies s on p.product_id = s.product_id
where type_name = 'legume-fructe';

#39 Write a query that selects the set of products provided between # 1/1/2017 # and # 31/12/2017 #.
select p.product_name, t.type_name, s.supply_date
from products.products p
join products.product_types t on p.type_id = t.product_type_id
join products.supplies s on p.product_id = s.product_id
where supply_date between '2017-01-01' and '2017-12-31';

#40 Write a query in which you list the set of suppliers that supply products in 2017, in descending order of the price of the products supplied.
select p.product_name, t.type_name, s.supply_date, s.price
from products.products p
join products.product_types t on p.type_id = t.product_type_id
join products.supplies s on p.product_id = s.product_id
where supply_date between '2017-01-01' and '2017-12-31'
order by price desc;

#41 Remove duplicate providers from the previous query.
select DISTINCT peo.person_id, peo.last_name, peo.first_name, peo.tax_id, price
from products.products p
join products.product_types t on p.type_id = t.product_type_id
join products.supplies s on p.product_id = s.product_id
join products.people peo on s.supplier_id = peo.person_id
where supply_date between '2017-01-01' and '2017-12-31'
order by price desc;

#42 Write a query to display today's date. The column will be called Today.
SELECT CURRENT_DATE AS "Today";

#43 For each line in SUPPLIES, Compute the number of months from the Date on the line until today.
select p.product_name, s.supply_date,
EXTRACT(YEAR FROM AGE(current_date, s.supply_date)) * 12 +
EXTRACT(MONTH FROM AGE(current_date, s.supply_date)) AS months_since_supply
from products.products p
join products.supplies s on p.product_id = s.product_id;

#44 Using the concatenation function, display a column with the text "Supplier X supplies product Y '.
select concat('Supplier ', peo.last_name, ' ', peo.first_name, ' supplies product ', p.product_name) as text
from products.products p
join products.supplies s on p.product_id = s.product_id
join products.people peo on s.supplier_id = peo.person_id;

#45 Show all products for which Data is missing in the FURNIZARI relationship.
select p.product_name, s.price, s.supply_date
from products.products p
join products.supplies s on p.product_id = s.product_id
where p.type_id is null or p.mu_id is null or s.price is null or supply_date is null;





























-- CREATE TABLE Department (
--     IdDepartment SERIAL PRIMARY KEY,
--     DName VARCHAR(100) NOT NULL,
--     Floor INTEGER NOT NULL
-- );

-- CREATE TABLE Employee (
--     IdEmployee serial PRIMARY KEY,
--     EmployeeCode VARCHAR(10) NOT NULL,
--     ESurname VARCHAR(100) NOT NULL,
--     EName VARCHAR(100) NOT NULL,
--     EmployeeDate DATE NOT NULL,
--     Manager INTEGER REFERENCES Employee(IdEmployee),
--     Department INTEGER NOT NULL REFERENCES Department(IdDepartment),
--     Salary NUMERIC(10, 2) NOT NULL
-- );

-- CREATE TABLE Product (
--     IdProduct serial PRIMARY KEY,
--     BarCode VARCHAR(50) NOT NULL,
--     Price NUMERIC(10, 2) NOT NULL,
--     Department INTEGER NOT NULL REFERENCES Department(IdDepartment),
--     ProductName VARCHAR(200) NOT NULL
-- );

-- CREATE TABLE Sale (
--     IdSale INTEGER PRIMARY KEY,
--     Product INTEGER NOT NULL REFERENCES Product(IdProduct),
--     Employee INTEGER NOT NULL REFERENCES Employee(IdEmployee),
--     SaleDate DATE NOT NULL,
--     SaleCode VARCHAR(20) UNIQUE NOT NULL
-- );



















-- INSERT INTO Department (IdDepartment, DName, Floor) VALUES
-- ('Computers', 1),
-- ('Electronics', 2),
-- ('Bathroom', 3),
-- ('Construction', 1),
-- ('Cleaning', 2),
-- ('Food', 1);

-- INSERT INTO Employee (IdEmployee, EmployeeCode, ESurname, EName, EmployeeDate, Manager, Department, Salary) VALUES
-- (1, 'A1', 'Pop', 'Ion', TO_DATE('12/05/2000', 'DD/MM/YYYY'), 4, 1, 1500.00),
-- (2, 'A2', 'Marin', 'Ioana', TO_DATE('13/04/2001', 'DD/MM/YYYY'), 1, 1, 1400.00),
-- (3, 'A3', 'Vlad', 'Cristi', TO_DATE('14/06/2002', 'DD/MM/YYYY'), 1, 1, 1300.00),
-- (4, 'A4', 'Popa', 'Dan', TO_DATE('15/08/2000', 'DD/MM/YYYY'), NULL, 1, 2000.00),
-- (5, 'A5', 'Amza', 'Dana', TO_DATE('16/09/2002', 'DD/MM/YYYY'), 2, 1, 1200.00),
-- (6, 'A6', 'Cristea', 'Elena', TO_DATE('17/10/2003', 'DD/MM/YYYY'), NULL, 2, 2000.00),
-- (7, 'A7', 'Popescu', 'Lizeta', TO_DATE('12/10/2004', 'DD/MM/YYYY'), 5, 1, 1100.00),
-- (8, 'A8', 'Popoviciu', 'Emil', TO_DATE('01/10/2005', 'DD/MM/YYYY'), 5, 1, 1000.00),
-- (9, 'A9', 'Dutu', 'Nelu', TO_DATE('15/10/2006', 'DD/MM/YYYY'), 6, 2, 2000.00),
-- (10, 'A10', 'Miroiu', 'Florentina', TO_DATE('15/10/2006', 'DD/MM/YYYY'), 13, 4, 1000.00),
-- (11, 'A11', 'Popa', 'Maria', TO_DATE('01/01/2001', 'DD/MM/YYYY'), 13, 4, 1400.00),
-- (12, 'A12', 'Beraru', 'Florin', TO_DATE('01/01/2003', 'DD/MM/YYYY'), 13, 4, 1300.00),
-- (13, 'A13', 'Cioca', 'Ion', TO_DATE('01/01/1999', 'DD/MM/YYYY'), NULL, 4, 2000.00),
-- (14, 'A17', 'Barbu', 'Eugen', TO_DATE('01/04/2013', 'DD/MM/YYYY'), 6, 2, 2500.00),
-- (15, 'A18', 'Ciocoiu', 'Vlad', TO_DATE('02/03/2013', 'DD/MM/YYYY'), 6, 2, 3000.00),
-- (16, 'A20', 'Sef', 'Degeaba', TO_DATE('01/03/2013', 'DD/MM/YYYY'), NULL, 4, 3000.00),
-- (17, 'A21', 'Lucrator', 'Degeaba', TO_DATE('01/03/2013', 'DD/MM/YYYY'), 16, 4, 2000.00);


-- INSERT INTO Product (IdProduct, BarCode, Price, Department, ProductName) VALUES
-- (1, '123', 200.00, 1, 'Cooler laptop'),
-- (2, '112', 200.00, 1, 'Laptop Toshiba'),
-- (3, '111', 150.00, 1, 'Laptop Acer'),
-- (4, '113', 165.00, 1, 'Laptop HP'),
-- (5, '12211', 100.00, 2, 'Lamp'),
-- (6, '1121', 100.00, 4, 'something'),
-- (7, '1122', 1000.00, 4, 'Board'),
-- (9, '1212', 900.00, 4, 'Mattress'),
-- (10, '11256', 250.00, 2, 'Oven'),
-- (11, '12356', 600.00, 2, 'Stove');


-- INSERT INTO Sale (IdSale, Product, Employee, SaleDate, SaleCode) VALUES
-- (1, 3, 5, TO_DATE('11/11/2007', 'DD/MM/YYYY'), 'V1'),
-- (2, 2, 5, TO_DATE('12/11/2007', 'DD/MM/YYYY'), 'V2'),
-- (3, 6, 10, TO_DATE('01/12/2007', 'DD/MM/YYYY'), 'V3'),
-- (4, 6, 13, TO_DATE('01/12/2007', 'DD/MM/YYYY'), 'V4'),
-- (5, 9, 10, TO_DATE('11/01/2008', 'DD/MM/YYYY'), 'V5'),
-- (6, 9, 13, TO_DATE('12/02/2008', 'DD/MM/YYYY'), 'V6'),
-- (7, 5, 6, TO_DATE('16/02/2013', 'DD/MM/YYYY'), 'V7'),
-- (8, 10, 6, TO_DATE('17/02/2010', 'DD/MM/YYYY'), 'V8'),
-- (9, 11, 6, TO_DATE('17/03/2011', 'DD/MM/YYYY'), 'V9'),
-- (10, 4, 1, TO_DATE('01/03/2012', 'DD/MM/YYYY'), 'V10'),
-- (11, 1, 7, TO_DATE('01/04/2013', 'DD/MM/YYYY'), 'V11'),
-- (13, 1, 5, TO_DATE('10/04/2012', 'DD/MM/YYYY'), 'V12'),
-- (14, 2, 5, TO_DATE('04/05/2010', 'DD/MM/YYYY'), 'V13'),
-- (15, 2, 5, TO_DATE('05/05/2008', 'DD/MM/YYYY'), 'V14'),
-- (16, 4, 5, TO_DATE('05/05/2008', 'DD/MM/YYYY'), 'V15'),
-- (17, 9, 9, TO_DATE('01/04/2013', 'DD/MM/YYYY'), 'V16');



