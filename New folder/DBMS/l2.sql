
-- Joins

1. select distinct job_title from employees e
join jobs j on j.job_id = e.job_id;

2. select last_name || ' ' || first_name FullName, job_title, city from employees e
join jobs j on j.job_id = e.job_id
join departments d on d.department_id = e.department_id
join locations l on l.location_id= d.location_id;

7. select city, department_name from departments d
right join locations l on l.location_id= d.location_id;

8. select city, department_name from departments d
right join locations l on l.location_id= d.location_id
where department_name is null;

10. SELECT 
    e.last_name || ' ' || e.first_name AS employee_full_name,
    e.employee_id,
    e.manager_id,
    emp.last_name || ' ' || emp.first_name AS manager_full_name,
    emp.employee_id AS manager_employee_id
FROM employees e
JOIN employees emp 
    ON e.manager_id = emp.employee_id;

12. select e.employee_id Employee_Id, 
e. last_name || ' ' || e.first_name FullName_Employee,
d1.department_name Employees_Department,
m.employee_id Manager_Id, 
m.last_name || ' ' || m.first_name FullName_Manager,
d2.department_name Managers_Department
from employees e
join departments d1 on d1.department_id = e.department_id
join employees m on m.employee_id= e.manager_id
join departments d2 on d2.department_id = m.department_id
order by m.first_name;


16.  select employee_id, j.job_title, d.department_name, MONTHS_BETWEEN(h.end_date, h.start_date) MonthsWorked from employees e
left join job_history h on h.employee_id = e.employee_id
left join departments d on h.department_id = d.department_id
left join jobs j on j.job_id = h.job_id;

19.  select  
e1.last_name || ' ' || e1.first_name FullName_Employee, 
e1.employee_id Employee_id,
e1.commision_pct CommisisonEmployee, 
e1.last_name || ' ' || e1.first_name FullName_Employer,
e2.comission_pct CommissionEmployer,
e2.employee_id Manager_Id
from employees e1
join employees e2 on e1.employee_id = e2.manager_id
where e1.commission_pct > nvl(e2.commission_pct);


-- Data aggregation


1. select count(employee_id) nr_of_employees, min(salary), max(salary)  from employees;

2. select count(employee_id) nr_of_employees, min(salary), max(salary), avg(salary), d.department_name
from employees e
join departments d on d.department_id = e.department_id
group by d.department_name;

3. select * from employees e
join departments d on d.department_id = e.department_id;

4. SELECT MIN(salary) AS lowest_salary
FROM employees
WHERE manager_id IS NOT NULL;


-- Subqueries

1. SELECT e.first_name,
       e.last_name,
       e.employee_id
FROM employees e
WHERE e.job_id = (
    SELECT emp.job_id
    FROM employees emp
    WHERE emp.last_name = 'De Haan'
);

7. 
select first_name, last_name, employee_id, salary from employees
where salary > 
(select avg(salary) from employees)
order by salary

8. select e.first_name, e.last_name, e.salary, d.department_id, d.department_name from employees e
join departments d on d.department_id = e.department_id
where salary > (
    select avg(emp.salary) from employees emp
    join departments d on d.department_id = emp.department_id
)
order by e.salary desc;

10. SELECT 
    m.employee_id AS manager_id,
    m.first_name || ' ' || m.last_name AS manager_name,
    MIN(e.salary) AS lowest_employee_salary
FROM employees e
JOIN employees m 
    ON e.manager_id = m.employee_id
GROUP BY 
    m.employee_id,
    m.first_name,
    m.last_name
HAVING 
    MIN(e.salary) > (
        SELECT AVG(salary)
        FROM employees
    )
ORDER BY 
    lowest_employee_salary;


12. SELECT 
    m.last_name, count(e.employee_id)
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
GROUP BY 
    m.employee_id,
    m.first_name,
    m.last_name
  ORDER BY 
    COUNT(e.employee_id)
FETCH FIRST 1 ROWS ONLY;

15.  SELECT 
    e.first_name || ' ' || e.last_name AS employee_name,
    e.salary
FROM employees e
WHERE e.salary > (
    SELECT AVG(DISTINCT m.salary)
    FROM employees m
    WHERE m.employee_id IN (
        SELECT DISTINCT manager_id
        FROM employees
        WHERE manager_id IS NOT NULL
    )
)
ORDER BY e.salary;
