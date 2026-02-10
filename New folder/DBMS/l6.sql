
1.
DECLARE
    a NUMBER := TO_NUMBER(:P1_NUM1);
    b NUMBER := TO_NUMBER(:P1_NUM2);
    result NUMBER;
BEGIN
    IF b = 0 THEN
        result := a * a;
    ELSE
        result := (a / b) + b;
    END IF;

    :P1_RESULT := result;  
END;

2.
CREATE TABLE messages (
    result VARCHAR2(80)
);
BEGIN
    FOR i IN 1 .. 10 LOOP
        IF i NOT IN (6, 8) THEN
            INSERT INTO messages (result)
            VALUES (TO_CHAR(i));
        END IF;
    END LOOP;

    COMMIT;
END;


3.
alter table EMP_CFlavian
add column Stars VARCHAR2(50)

DECLARE
    v_empno EMP_CFlavian.job_id%TYPE;
    v_asterisk EMP_CFlavian.stars%TYPE;
    v_sal EMP_CFlavian.salary%TYPE;
    v_count NUMBER;
BEGIN
    v_empno    := 176;
    v_asterisk := NULL;

    SELECT salary
    INTO v_sal
    FROM EMP_CFlavian
    WHERE employee_id = 176;

    v_count := TRUNC(v_sal / 1000);

    FOR i IN 1 .. v_count LOOP
        v_asterisk := v_asterisk || '*';
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Generated stars: ' || v_asterisk);
END

4.
create table NUMBERS(
counter INTEGER,
text VARCHAR2(500)
)

DECLARE
    v_counter NUMBER := 0; 
    v_num     NUMBER := 1;   
BEGIN
    WHILE v_counter < 10 LOOP   

        FOR i IN 1 .. 1 LOOP 
        
            IF MOD(v_num, 3) = 0 THEN
                INSERT INTO NUMBERS (counter, text)
                VALUES (v_num, 'index');
                
                v_counter := v_counter + 1;
            END IF;
            
            v_num := v_num + 1;
        END LOOP;

    END WHILE;
END;

5.
ALTER TABLE EMP_eremia
ADD commission NUMBER;
DECLARE
    v_inCode NUMBER := :v_inCode;
    v_salary EMP_eremia.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_salary
    FROM EMP_eremia
    WHERE employee_id = v_inCode;
    IF v_salary < 1000 THEN
        UPDATE EMP_eremia
        SET commission = 0.1
        WHERE employee_id = v_inCode;
    ELSIF v_salary BETWEEN 1000 AND 1500 THEN
        UPDATE EMP_eremia 
        SET commission = 0.15
        WHERE employee_id = v_inCode;
    ELSE
        UPDATE EMP_eremia
        SET commission = 0.2
        WHERE employee_id = v_inCode;
    END IF;
END;



ex. 2

1.
DECLARE
 v_nr1 NUMBER := &nr1;
 v_nr2 NUMBER := &nr2;
 v_result NUMBER;
BEGIN
  if v_nr2 = 0
    v_result := v_nr1 * v_nr1
  else 
    v_result := (v_nr1 / v_nr2) + v_nr2
  end if;  

DBMS_OUTPUT.PUT_LINE('The result is: ' ||  v_result);
END

2.
create table c_flavian_mesages(
    results VARCHAR2(80)
)

DECLARE
  counter NUMBER := 1;
BEGIN
   while counter < 10 LOOP

    IF counter = 6 OR counter = 8 THEN
      counter := counter + 1;
      CONTINUE;
    END IF;

     insert into c_flavian_mesages (results) values ( to_char(counter) )
   
      counter := counter + 1;
   end loop
END

3.
DECLARE
  v_empno EMP_CFlavian.employee_id%TYPE := 176;
  v_asterisk EMP_CFlavian.stars%TYPE;
  v_sal EMP_CFlavian.salary%TYPE;
BEGIN
 select salary
 into v_sal
 from EMP_CFlavian
 where employee_id = v_empno

 FOR i IN 1 .. TRUNC(v_sal / 1000) LOOP
    v_asterisk := v_asterisk || '*';
  END LOOP;

  UPDATE EMP_CFlavian
  SET stars = v_asterisk
  WHERE employee_id = v_empno;
END