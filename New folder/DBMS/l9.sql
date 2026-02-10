
1.
declare 
    vlName Employees.Last_Name%type;
begin 
    select last_name
    into vlName
    from Employees
    where salary = 30000;
    DBMS_OUTPUT.PUT_LINE(vlName);
    EXCEPTION
        WHEN too_many_rows THEN
            DBMS_OUTPUT.PUT_LINE('Exista mai multi angajati cu salariul 6000');
        WHEN no_data_found THEN
            DBMS_OUTPUT.PUT_LINE('Nu exista angajati cu acest salariu');
end;

2.
declare 
    exp exception;
    Pragma exception_init(exp, -02292);
begin
    DBMS_OUTPUT.PUT_LINE('Incercam sa stergem angajatul cu id 124');
    DELETE Employees 
    WHERE Employee_ID = 130;

    DBMS_OUTPUT.PUT_LINE('Succes');

    exception 
        WHEN exp THEN
            DBMS_OUTPUT.PUT_LINE('Angajatul nu poate fi sters pt ca este manager');
end;

3.
declare
    vnr number;
    no_depts EXCEPTION;
begin 
    SELECT count(distinct department_id)
    INTO vnr
    FROM Employees
    WHERE salary > 25000;

    IF vnr = 0 THEN
        RAISE no_depts;
    END IF;
    DBMS_OUTPUT.PUT_LINE(vnr);
    EXCEPTION
        WHEN no_depts THEN
            DBMS_OUTPUT.PUT_LINE('Nu exista departamente cu angajati cu salariul mai mare decat 6000');
end;

4.
create or replace procedure VerifComision(empID Employees.Employee_ID%type)
    is 
    vcom Employees.Commission_pct%type;
    begin
        select commission_pct
        into vcom
        from employees
        where employee_id = empID;
        if vcom is null then
            raise_application_error(-20005,'Angajatul nu are comision');
        END IF;
        DBMS_OUTPUT.PUT_LINE(vcom);
    end;

declare
    exp EXCEPTION;
    pragma exception_init(exp, -20005);
begin
    VerifComision(169);
    EXCEPTION 
        WHEN exp THEN
            DBMS_OUTPUT.PUT_LINE(sqlerrm(-20005));
end;