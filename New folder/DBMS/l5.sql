
CREATE TABLE EMP_CFlavian AS
SELECT * FROM EMPLOYEES
ALTER TABLE EMP_CFlavian add constraint EMPFlavian_pk primary key (employee_id)
ALTER TABLE EMP_CFlavian add constraint empCFlavian_Uemail unique(email)
ALTER TABLE EMP_CFlavian add constraint empCFlavian_checkSalariu check(salary>0)
ALTER TABLE EMP_CFlavian add constraint empCFlavian_fkJob foreign Key(job_id) references jobs_CFlavian(job_id)
ALTER TABLE EMP_CFlavian add constraint empCFlavian_fkManager foreign Key(manager_id) references emp_CFlavian(employee_id)
ALTER TABLE EMP_CFlavian add constraint empCFlavian_fkDept foreign Key(department_id) references dept_CFlavian(department_id)

CREATE TABLE Dept_CFlavian AS 
SELECT * FROM DEPARTMENTS
ALTER TABLE Dept_CFlavian add constraint depFlavian_pk primary key (department_id)

SELECT uc.constraint_type,uc.constraint_name,uc.table_name,ucc.column_name,uc.search_condition_vc
FROM user_constraints uc 
JOIN user_cons_columns ucc on ucc.constraint_name = uc.constraint_name
WHERE uc.table_name = 'EMPLOYEES';

SELECT uc.constraint_type,uc.constraint_name,uc.table_name,ucc.column_name,uc.search_condition_vc,uc_pk.table_name TableReferit
FROM user_constraints uc 
JOIN user_cons_columns ucc on ucc.constraint_name = uc.constraint_name
JOIN user_constraints uc_pk on uc.r_constraint_name = uc_pk.constraint_name
WHERE uc.table_name = 'EMPLOYEES';


CREATE TABLE Jobs_CFlavian AS
SELECT * FROM JOBS
ALTER TABLE jobs_CFlavian add constraint jobFlaviani_pk primary key (job_id)
ALTER TABLE jobs_CFlavian drop constraint jobFlaviani_fk

CREATE TABLE Locations_CFlavian AS
SELECT * FROM Locations
ALTER TABLE locations_CFlavian add constraint locationFlaviani_pk primary key (location_id)

1.
DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello World!');
END;

2.
DECLARE
v_today DATE := SYSDATE;
v_tomorrow v_today%type;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello World!');
  v_tomorrow := v_today + 1;
  DBMS_OUTPUT.PUT_LINE(v_tomorrow);
END;

3.
DECLARE
  v_oras  locations.city%TYPE;
BEGIN
  SELECT l.city
  INTO v_oras
  FROM locations l
  JOIN departments d
    ON d.location_id = l.location_id
  WHERE d.department_id = 30;

  DBMS_OUTPUT.PUT_LINE('City: ' || v_oras);
END;

4.
DECLARE
  v_max_deptno departments.department_name%TYPE;
BEGIN
  SELECT max(d.department_name)
  INTO v_max_deptno
  FROM departments d;

  DBMS_OUTPUT.PUT_LINE('Department_name: ' || v_max_deptno);
END;

5.
DECLARE
  v_new_id  departments.department_id%TYPE;
BEGIN
  SELECT NVL(MAX(department_id), 0) + 1
  INTO v_new_id
  FROM departments;

  INSERT INTO departments (department_id, department_name, location_id)
  VALUES (v_new_id, :p_dept_name, NULL);

  DBMS_OUTPUT.PUT_LINE('Department inserted with ID = ' || v_new_id);
END;


6.
DECLARE
  v_new_id  departments.department_id%TYPE;
BEGIN
  UPDATE departments
  SET location_id = 3000
  WHERE department_id = v_new_id;

  DBMS_OUTPUT.PUT_LINE('Department ' || v_new_id || ' updated to location_id = 3000');
END;
/

7.
DECLARE
  v_dept_id  departments.department_id%TYPE := &dept_id;
BEGIN
  DELETE FROM departments
  WHERE department_id = v_dept_id;

    DBMS_OUTPUT.PUT_LINE('Department ' || v_dept_id || ' deleted successfully.');
END;



8.
DECLARE
  v_media_sal employees.salary%TYPE;
  v_dept employees.department_id%TYPE := 50;
BEGIN
   select avg(salary)
   into v_media_sal
   from employees
   where department_id = v_dept;

   DBMS_OUTPUT.PUT_LINE('Average salary in department 50: ' || v_media_sal);
END

9.
DECLARE
v_salary employees.salary%TYPE;
v_job_id employees.job_id%TYPE := '&user_output_id';
BEGIN
   select sum(salary)
   into v_salary
   from employees
   where job_id = v_job_id;

DBMS_OUTPUT.PUT_LINE('Total salary: ' || v_salary || ' where the job_id is: ' || user_output_id);
END

select sum(salary) from employees where job_id = 'AD_VP';