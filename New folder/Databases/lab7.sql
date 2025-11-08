
1. select p.product_name, pt.type_name from
products.products p
left join products.product_types pt on p.type_id = pt.product_type_id
order by p.product_name;

2.select peo.first_name, peo.last_name, p.product_name from
products.products p
left join products.supplies s on s.product_id = p.product_id
left join products.people peo on peo.person_id = s.supplier_id
order by peo.last_name; 

4. select p.last_name, p.first_name, s.supply_date
from products.supplies s
join products.people p on p.person_id = s.supplier_id
where p.last_name = 'Popescu'
and s.supply_date > '01-01-2015';

5. select p.product_name, s.supply_date
from products.supplies s
join products.products p on p.product_id = s.product_id
where supply_date >= (CURRENT_DATE - INTERVAL '6 months');

6. select p.product_name, peo.last_name, peo.first_name, s.supply_date
from products.supplies s
join products.products p on p.product_id = s.product_id
join products.people peo on peo.person_id = s.supplier_id
where s.supply_date < '01-01-2015';

7. select pt.type_name, p.product_name, EXTRACT(MONTH FROM s.supply_date) AS supply_month 
from products.supplies s
join products.products p on p.product_id = s.product_id
join products.product_types pt on pt.product_type_id = p.type_id;

8. select p.product_id, p.product_name, s.supply_date
from products.supplies s
join products.products p on p.product_id = s.product_id
where s.supply_date between '01-01-2017' and '31-12-2017';

9. select peo.last_name, peo.first_name, p.product_name, s.price, s.supply_date
from products.supplies s
join products.products p on p.product_id = s.product_id
join products.people peo on peo.person_id = s.supplier_id
where s.supply_date between '01-01-2017' and '31-12-2017'
order by s.price desc;

10. select distinct peo.last_name, peo.first_name, p.product_name, s.price, s.supply_date
from products.supplies s
join products.products p on p.product_id = s.product_id
join products.people peo on peo.person_id = s.supplier_id
where s.supply_date between '01-01-2017' and '31-12-2017'
order by s.price desc;

11. SELECT CURRENT_DATE AS "Today";

12. SELECT s.price, supply_date,
(EXTRACT(year from CURRENT_date) - EXTRACT(YEAR FROM supply_date)) * 12 +
(EXTRACT(MONTH FROM CURRENT_DATE) - EXTRACT(MONTH FROM supply_date)) AS months_since_supply
from products.supplies s;

13. SELECT 'Supplier' || ' ' || peo.last_name || ' ' || peo.first_name || ' supplies you product ' || p.product_name as text
from products.supplies s
join products.people peo on peo.person_id = s.supplier_id
join products.products p on p.product_id = s.product_id;

14. SELECT p.product_name, s.price, s.supply_date
from products.supplies s
left join products.products p on p.product_id = s.product_id
where supply_date is null;

15. SELECT p.product_id, p.product_name
from products.products p
where p.product_name like '%a';




2.SELECT mu.short_name,
count(p.product_name)
from products.products p
join products.measurement_units mu on mu.mu_id = p.mu_id
group by mu.short_name
order by mu.short_name;

3.SELECT p.product_name, pt.type_name
from products.products p
right join products.product_types pt on pt.product_type_id  = p.type_id
where p.product_name is null;

4. SELECT p.product_name, mu.short_name
from products.products p
right join products.measurement_units mu on mu.mu_id = p.mu_id
where product_name is null;

6.  SELECT p.product_id, p.product_name
FROM supplies s
JOIN products p ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name
HAVING COUNT(DISTINCT s.supplier_id) >= 2
ORDER BY p.product_name DESC;

7.select p.product_name,
count(s.supplier_id)
from 
products.products p
left join products.supplies s on p.product_id = s.product_id
group by p.product_name
order by p.product_name

8.select p.product_name, s.price from
products.products p
join products.supplies s on s.product_id = p.product_id
group by p.product_name, s.price
having s.price > 1000

9. select p.product_name, min(s.price), max(s.price)
from products.products p
left join products.supplies s on s.product_id = p.product_id
group by p.product_name
order by p.product_name

10. select p.product_name, avg(s.price)
from products.products p
join products.supplies s on s.product_id = p.product_id
group by p.product_name

11.select  p.product_name, s.price
from products.products p
join products.supplies s on s.product_id = p.product_id
where s.price > 1000

12.select 
count(distinct supplier_id)
from products.products p
join products.supplies s on s.product_id = p.product_id
join products.people peo on peo.person_id = s.supplier_id
where s.price < 10000

13. select peo.first_name, peo.last_name, COUNT(DISTINCT s.product_id) AS product_count
from products.products p
join products.supplies s on s.product_id = p.product_id
join products.people peo on peo.person_id = s.supplier_id
GROUP BY 
    peo.last_name, peo.first_name
HAVING 
    COUNT(DISTINCT s.product_id) >= 2;

14. select peo.last_name, count(p.product_id)
from products.products p
join products.supplies s on s.product_id = p.product_id
join products.people peo on peo.person_id = s.supplier_id
group by peo.last_name

15. select pt.type_name, count(distinct product_name) 
from products.products p
join products.product_types pt on pt.product_type_id = p.type_id
group by pt.type_name

16. select mu.short_name, count(p.product_id)
from products.products p
join products.measurement_units mu on mu.mu_id = p.mu_id
group by mu.short_name

18. select peo.last_name, avg(s.price)
from products.products p
join products.supplies s on s.product_id = p.product_id
join products.people peo on peo.person_id = s.supplier_id
group by peo.last_name

19. select pt.type_name, avg(s.price)
from products.products p
join products.product_types pt on pt.product_type_id = p.type_id
join products.supplies s on s.product_id = p.product_id
group by pt.type_name







1. SELECT 
    d.IdDepartment,
    d.DName,
    SUM(p.Price) AS TotalRevenue,
    COUNT(DISTINCT s.Employee) AS NumberOfEmployees
FROM 
    Department d
JOIN 
    Product p ON p.Department = d.IdDepartment
JOIN 
    Sale s ON s.Product = p.IdProduct
GROUP BY 
    d.IdDepartment, d.DName
ORDER BY 
    TotalRevenue DESC;

3..select TO_CHAR(s.saledate, 'Month') as months, sum(p.price), count(s.idsale)  from
Departaments d
join products p on p.Department = d.IdDepartment
join sales s on p.idproduct = s.product
where s.saledate between '01-01-2007' and '31-12-2007'
group by months
order by sum(p.price) desc

4. select e.idemployee, e.esurname ||' '|| e.ename as fullname from
employees e
left join sales s on s.employee = e.idemployee
where s.idsale is null;

5. select p.productname, count(s.product) as salesNr from
Departaments d 
join products p on p.Department = d.IdDepartment
left join sales s on s.Product = p.IdProduct
group by p.productname
having count(s.product) < 1

