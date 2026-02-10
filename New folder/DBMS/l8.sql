
1.
DECLARE
  v_deptno NUMBER := 10;
   
  CURSOR c_emp_cursor IS
    SELECT last_name, salary, manager_id
    FROM employees
    WHERE department_id = v_deptno;
BEGIN
  FOR emp_rec IN c_emp_cursor LOOP
    IF emp_rec.salary <= 5000 AND emp_rec.manager_id IN (101, 124) THEN
      DBMS_OUTPUT.PUT_LINE(emp_rec.last_name || ' must receive a salary increase');
    ELSE
      DBMS_OUTPUT.PUT_LINE(emp_rec.last_name || ' should not receive a salary increase');
    END IF;
  END LOOP;
END;

2.
DECLARE
  TYPE DeptList IS TABLE OF NUMBER;
  dept_id_list DeptList := DeptList(50,60,70);

  CURSOR c_dept_cursor (dept_id departments.department_id%TYPE) IS
    SELECT last_name, salary
    FROM employees
    WHERE department_id = dept_id;
BEGIN
  FOR i IN dept_id_list.first..dept_id_list.last LOOP
    FOR emp_rec IN c_dept_cursor (dept_id_list(i)) LOOP
      DBMS_OUTPUT.PUT_LINE(emp_rec.last_name || ' has the annual salary ' || emp_rec.salary || ' and the department id is ' || dept_id_list(i));
    END LOOP;
  END LOOP;
END;


3.
DECLARE
   v_dept_id     departments.department_id%TYPE;
   v_dept_name   departments.department_name%TYPE;

   v_last_name   employees.last_name%TYPE;
   v_job_title   jobs.job_title%TYPE;
   v_hire_date   employees.hire_date%TYPE;
   v_salary      employees.salary%TYPE;

   CURSOR c_dept_cursor IS
      SELECT department_id, department_name
      FROM departments
      WHERE department_id < 100;

   CURSOR c_emp_cursor (p_dept_id departments.department_id%TYPE) IS
      SELECT e.last_name,
             j.job_title,
             e.hire_date,
             e.salary
      FROM employees e
      JOIN jobs j
        ON j.job_id = e.job_id
      WHERE e.employee_id < 120
        AND e.department_id = p_dept_id;

BEGIN
   FOR i IN c_dept_cursor LOOP

      DBMS_OUTPUT.PUT_LINE(
         'Department ID: ' || i.department_id ||
         ' | Department Name: ' || i.department_name
      );

      FOR j IN c_emp_cursor(i.department_id) LOOP

         DBMS_OUTPUT.PUT_LINE(
            '   Last Name: ' || j.last_name ||
            ' | Job Title: ' || j.job_title ||
            ' | Hire Date: ' || j.hire_date ||
            ' | Salary: ' || j.salary
         );

      END LOOP;

   END LOOP;
END;

4.
CREATE TABLE C_EMPLOYEES_Flavian 
as select * from employees;


DECLARE
  cursor c_cursor_employees (c_dept_id employees.department_id %TYPE) is
  select employee_id, salary
  from employees
  where department_id = c_dept_id;

  v_record c_cursor_employees%ROWTYPE;
BEGIN
  for i in c_cursor_employees(<dept_id>) LOOP
      if i.salary < 5000 then
         UPDATE c_employees_flavian
         SET commission_pct = 0.05
         WHERE employee_id = i.employee_id;
  end loop        
end