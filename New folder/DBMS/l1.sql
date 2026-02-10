-- dbms@cs3

2. SELECT * from departments;

3. SELECT first_name, last_name, hire_date as "Data angajarii", employee_id from employees;

4. SELECT distinct (employee_id) from employees;

5. SELECT last_name || ', ' || first_name Angajat FROM employees;

6. SELECT last_name || ', ' || first_name, salary FROM employees where salary > 12000;

7. SELECT last_name || ', ' || first_name, department_id FROM employees where employee_id = 176;

8. SELECT * FROM employees where hire_date between '02/20/2000' and '05/01/2005';

9. select * from employees where salary < 5000 or salary > 12000;

10. select last_name || ', ' || first_name FullName, department_id from employees where department_id in (20, 50)
order by last_name;

11. select * from employees where manager_id is null;

12. select last_name || ', ' || first_name FullName, salary, commission_pct from employees where commission_pct is not null
order by commission_pct desc;

13. select last_name || ', ' || first_name FullName from employees where last_name LIKE '__a%';

14. select last_name || ', ' || first_name FullName from employees where last_name LIKE '%e%';

Exercise 2

1. SELECT SYSDATE AS current_date
FROM DUAL;

2. SELECT last_name || ', ' || first_name || ', ' || salary Fullname_And_Salary from employees where salary > 12000;

3. SELECT last_name || ', ' || first_name FullName, hire_date Date_Of_Employment from employees

4. SELECT last_name || ', ' || first_name FullName, salary Current_Salary, round(salary + salary/15) NewSalary from employees;

5. SELECT last_name || ', ' || first_name FullName, salary Current_Salary, round(salary + salary/15) NewSalary, round(salary + salary/15) - salary Increase from employees;

6. SELECT last_name || ', ' || first_name FullName, length(last_name) + length(first_name) FullName_Length from employees;

7. SELECT last_name || ', ' || first_name FullName, length(last_name) + length(first_name) FullName_Length from employees where last_name in(like 'A%', like 'J%', like 'M%');

8. SELECT
    jh.employee_id,
    SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date)) AS Seniority
FROM job_history jh
GROUP BY jh.employee_id
ORDER BY Seniority;

9. SELECT
    jh.employee_id,
    ROUND(SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date))) AS Seniority
FROM job_history jh
GROUP BY jh.employee_id
ORDER BY Seniority;

10.
SELECT
    jh.employee_id,
    ROUND(SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date)) / 12, 2) AS Seniority
FROM job_history jh
GROUP BY jh.employee_id
ORDER BY Seniority;

11. SELECT first_name || ' ' || last_name || ' earns ' || salary || ' but dreams of ' || salary * 3 salary_dream from employees;

12. SELECT
    e.first_name,
    e.last_name,
    d.department_id,
    ROUND(SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date)) / 12, 2) AS years_worked
FROM employees e
JOIN departments d
    ON d.department_id = e.department_id
JOIN job_history jh
    ON jh.employee_id = e.employee_id
where d.department_id in (20,50)
GROUP BY
    e.first_name,
    e.last_name,
    d.department_id
HAVING
    SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date)) / 12 <= 25
ORDER BY
    years_worked;

13.
SELECT
    jh.employee_id,
    e.first_name,
    e.last_name,
    ROUND(SUM(MONTHS_BETWEEN(jh.end_date, jh.start_date)) / 12, 2) AS Seniority
FROM job_history jh
join employees e on e.employee_id = jh.employee_id
GROUP BY
    e.first_name,
    e.last_name,
    jh.employee_id
having e.first_name like 'A%'
ORDER BY Seniority;

15.
SELECT
    e.first_name || ' ' || e.last_name AS FullName,
    NVL(TO_CHAR(e.commission_pct), 'No commission') AS commission
FROM employees e;
