
1.
create or replace view view_nr1 as
select l.city, d.department_id, count(d.department_id), count(employee_id)
from locations l
join departments d on d.location_id = l.location_id
join employees e on e.department_id = d.department_id
group by l.city, d.department_id
having count(e.employee_id) > 10 and  count(d.department_id) > 2

2.
create table ANG_VECHIME(
    ang_id primary key,
    name varchar2,
    salary number,
    data_ang date
)

insert into ang_vechime(ang_id, name, salary, data_ang)
select employee_id, last_name, salary, hire_date from employees
where hire_date > extract(year from hire_date) < 2005;

3.
SELECT *FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES'AND COLUMN_NAME = 'SALARY';

4.
alter table ang_vechime add (
    fidelitate number;
)

5. 
insert into table ang_vechime(fidelitate)
SELECT
   salary,
   EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM hire_date) AS years_worked,
   salary * (EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM hire_date)) * 0.01 AS fidelitate
FROM employees;

6.
delete from ang_vechime(fidelitate) where
select max(extract(year from current_date) - extract(year from hire_date)) from employees

7.
update table ang_vechime (salary)
select * from employees
where salary > (
     select avg(salary), count(e.last_name), d.department_name from employees e
join departments d on d.department_id = e.department_id
group by d.department_name
HAVING COUNT(e.last_name) = (
   SELECT MAX(COUNT(e2.last_name))
   FROM employees e2
   GROUP BY e2.department_id
);
)

8.
