

-- Ex1. 


1. CREATE OR REPLACE VIEW EMPLOYEES_DEPTS(ID, NAME, DEPARTMENT)
AS SELECT e.employee_id, e.last_name, d.department_name from employees e
JOIN departments d on e.department_id = d.department_id;

2. select * from EMPLOYEES_DEPTS;

3. select * from EMPLOYEES_DEPTS
where department= 'Executive';

4. CREATE OR REPLACE VIEW DEPT50(EMPNO, EMPLOYEE, DEPTNO)
AS SELECT employee_id, last_name, department_id from employees
where department_id = 50
WITH CHECK OPTION;

5. UPDATE dept50
SET deptno = 80
WHERE employee = 'Matos';

ORA-01402: view WITH CHECK OPTION where-clause violation


-- Ex2.

1. CREATE SEQUENCE DEPT_ID_SEQ
INCREMENT BY 10
START WITH 280
MAXVALUE 1000

2. insert into departments(department_id, department_name, manager_id, location_id)
values ( DEPT_ID_SEQ.NEXTVAL, ' Research ' , 2, 2);


-- Ex. 3

1. CREATE INDEX EMP_DEPT_ID_IDX
ON employees (department_id);


- Ex. 4

1.
CREATE TABLE my_employee
(id NUMBER(4) CONSTRAINT my_employee_id_nn NOT NULL,
last_name VARCHAR2(25),
first_name VARCHAR2(25),
salary NUMBER(9,2));


2. CREATE SEQUENCE myemp_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 10;

3.
INSERT INTO my_employee (id, last_name, first_name, salary)
VALUES (myemp_seq.NEXTVAL, 'Smith', 'Mark', 500);

INSERT INTO my_employee (id, last_name, first_name, salary)
VALUES (myemp_seq.NEXTVAL, 'Stark', 'Bob', 1200);

INSERT INTO my_employee (id, last_name, first_name, salary)
VALUES (myemp_seq.NEXTVAL, 'Reeves', 'William', 850);

COMMIT;

4.  
UPDATE my_employee
SET last_name = 'Drexler'
WHERE id = 3;
COMMIT;

5. 
UPDATE my_employee
SET salary = 1000
WHERE salary < 900;
COMMIT;

6.
delete from my_employee 
where last_name = 'Drexler';
COMMIT;

7. 
delete from my_employee;
commit;


-- Ex. 5

create table emp(
    id number (7),
    last_name varchar2(25)
)

create table dept(
    id number (7),
    name varchar2(25)
)

ALTER TABLE emp
ADD (
    first_name VARCHAR2(25),
    dept_id    NUMBER(7)
)

1.
ALTER TABLE emp MODIFY last_name VARCHAR2(50);

2. create table emp(
    employee_id number (7),
    last_name varchar2(25)
    first_name VARCHAR2(25),
    salary number(7)
    dept_id NUMBER(7)
)

create table employees2 as (select employee_id id, last_name, first_name, salary, department_id dept_id from employees);

3. drop table emp;

4. rename employees2 to emp;

alter table employees2 add constraint pk_id primary key (id);

alter table dept add constraint pk_dept primary key (id);

alter table employees2 add constraint fk_dept_id foreign key (dept_id) references dept (id);

alter table employees2 modify dept_id number(7);

delete from employees2;

insert into employees2 (select employee_id, first_name, last_name, salary, department_id from employees where department_id = 50);

update employees2 set dept_id = 20 where salary > 7000;