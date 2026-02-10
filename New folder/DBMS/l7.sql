1.
DECLARE
  TYPE countryid_list IS TABLE OF VARCHAR2(2);

  v_country_ids  countryid_list := countryid_list('CA', 'UK', 'US');

  v_country_record COUNTRIES%ROWTYPE;
BEGIN
  FOR i IN v_country_ids.FIRST .. v_country_ids.LAST LOOP
    SELECT *
    INTO  v_country_record
    FROM  COUNTRIES
    WHERE country_id = v_country_ids(i);

    DBMS_OUTPUT.PUT_LINE('==========================');
    DBMS_OUTPUT.PUT_LINE('Country ID:  ' || v_country_record.country_id);
    DBMS_OUTPUT.PUT_LINE('Country Name: ' || v_country_record.country_name);
    DBMS_OUTPUT.PUT_LINE('Region ID:  ' || v_country_record.region_id);
  END LOOP;
END;

2.
DECLARE
   TYPE dept_table IS TABLE OF departments.department_name%TYPE
      INDEX BY PLS_INTEGER;

   my_dept_table   dept_table;

   loop_count  NUMBER := 10;
   deptno      NUMBER := 1; 
BEGIN
   FOR i IN 1 .. loop_count LOOP
      SELECT department_name
        INTO my_dept_table(i)
        FROM departments
       WHERE department_id = deptno * 10;

      deptno := deptno + 1; 
   END LOOP;

   FOR j IN my_dept_table.FIRST .. my_dept_table.LAST LOOP
      DBMS_OUTPUT.PUT_LINE(my_dept_table(j));
   END LOOP;

END;

3.
DECLARE
   dept_row  DEPT_student%ROWTYPE;
BEGIN
   SELECT *
     INTO dept_row
     FROM DEPT_student
    WHERE department_id = 10;

   dept_row.department_name := 'New Department Name';

   UPDATE DEPT_student
      SET department_name = dept_row.department_name
    WHERE department_id = dept_row.department_id;

   DBMS_OUTPUT.PUT_LINE('Department 10 updated to: ' || dept_row.department_name);

END;