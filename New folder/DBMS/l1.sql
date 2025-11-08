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


SELECT  last_name ,SUBSTR(last_name, 1, 1) name_with_first_letter from employees;