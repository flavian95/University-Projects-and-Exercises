
1.



2.
create table ANG_VECHIME(
    ANG_ID(number) PRIMARY KEY,
    NAME VARCHAR2(100),
    SALARY number,
    data_ang date
)

select 
employee_id, 
first_name, 
salary,
hire_date
from employees where
extract(year from hire_date) < 2005;


3.
SELECT column_name, data_type
FROM user_tab_columns
WHERE table_name = 'EMPLOYEES'
  AND column_name = 'SALARY';





 DELETE FROM
 ANG_VECHIMEWHERE DATA_ANG = (SELECT MIN(DATA_ANG) FROM ANG_VECHIME);
 
CREATE OR REPLACE VIEW V_DEPT_10_EMP AS 
SELECT d.DEPARTMENT_NAME,
d.LOCATION_ID,
COUNT(e.EMPLOYEE_ID) NrEmployees
FROM DEPARTMENTS d 
JOIN EMPLOYEES e ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
GROUP BY d.DEPARTMENT_NAME, 
d.LOCATION_ID
HAVING COUNT(e.EMPLOYEE_ID) >= 10;

SELECT *FROM V_DEPT_10_EMP;

CREATE OR REPLACE VIEW V_CITY_DEPT_STATS AS
SELECT l.CITY,
v.DEPARTMENT_NAME,    
COUNT() Nr_Departamente
FROM LOCATIONS lJOIN V_DEPT_10_EMP v 
ON l.LOCATION_ID = v.LOCATION_IDGROUP BY v.department_name,
l.cityHAVING COUNT() >= 1;

SELECT * FROM V_CITY_DEPT_STATS;

CREATE TABLE ANG_VECHIME (
    ANG_ID   NUMBER PRIMARY KEY,  
    NAME    VARCHAR2(100),  
    SALARY   NUMBER(8,2),  
    DATA_ANG  DATE);

INSERT INTO ANG_VECHIME (
    ANG_ID,
    NAME, 
    SALARY, 
    DATA_ANG)

SELECT EMPLOYEE_ID,
FIRST_NAME || ' ' || LAST_NAME,   
SALARY,     
HIRE_DATE 
FROM EMPLOYEES 
WHERE EXTRACT(YEAR FROM HIRE_DATE) < 2005;

SELECT * FROM ANG_VECHIME;

SELECT *FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES'AND COLUMN_NAME = 'SALARY';

DECLARE
    expManager exception;
    Pragma exception_init(expManager,-02292);
    myExp exception;
BEGIN
    DELETE FROM EMP_EREMIA e
    WHERE SALARY * COMMISSION_PCT > ((
        SELECT SALARY 
        FROM EMP_EREMIA  
        WHERE employee_id = e.manager_id) - e.salary) /2;
    IF SQL%NOTFOUND THEN
        RAISE myExp;
    END IF;
    DBMS_OUTPUT.PUT_LINE('Stergerea s a efectuat');
    EXCEPTION
        WHEN myExp THEN
            DBMS_OUTPUT.PUT_LINE('Nu exista angajati conform contitiilor date');
        WHEN expManager THEN
            DBMS_OUTPUT.PUT_LINE('Angajatul este manager');
END;



CREATE OR REPLACE TRIGGER TRG_CHECK_MIN_SALARY
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
  IF :NEW.SALARY < 1000 THEN
  RAISE_APPLICATION_ERROR(-20005, 'Error: Salary cannot be less than 1000. Attempted salary: ' || :NEW.SALARY);
  END IF;
END;

DECLARE
  myExp EXCEPTION;
  PRAGMA EXCEPTION_INIT(myExp, -20005);
BEGIN
  INSERT INTO employees
  ...
  DBMS_OUTPUT.PUT_LINE('A fost inserat');
  EXCEPTION 
  WHEN myExp
  THEN
  DBMS_OUTPUT.PUT_LINE(SQLERRM(-20005));
END;