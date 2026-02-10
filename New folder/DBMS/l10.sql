

2.  
create or replace procedure VerifSalariu(salariu Employees.Salary%type, idJob Employees.Job_ID%type)
    is
        vsalmin Jobs.min_salary%type;
        vsalmax Jobs.max_salary%type;
    begin
        select max_salary, min_salary
        into vsalmax, vsalmin
        from jobs
        where job_id = idJob;

        if salariu not between vsalmin and vsalmax AND salariu is not null then
            raise_application_error(-20005, 'Salariul nu este corespunzator jobului sau');
        end if;

        exception
            when no_data_found then
                raise_application_error(-20010, 'Nu exista jobul cu acest id');
        end;

create or replace trigger VerifSalariuTrigger
    before insert or update of salary, job_id on Employees
    for each row
        begin 
            if inserting then
                VerifSalariu(:new.salary,:new.job_id);
            else
                if :new.job_id is not null and :new.salary is not null then
                    VerifSalariu(:new.salary, :new.job_id);
                elsif :new.job_id is null and :new.salary is not null then
                    VerifSalariu(:new.salary, :old.job_id);
                elsif :new.job_id is not null and :new.salary is null then
                    VerifSalariu(:old.salary, :new.job_id);
                end if;
            end if;

        end;

declare
    exp1 exception;
    exp2 exception;
    pragma exception_init(exp1, -20005);
    pragma exception_init(exp1, -20010);
begin 
    Update employees
    set job_id = 'ADD'
    where employee_id = 160;

    exception
        when exp1 then
            DBMS_OUTPUT.PUT_LINE(sqlerrm(-20005));
        when exp2 then
            DBMS_OUTPUT.PUT_LINE(sqlerrm(-20010));
end;

select * from employees where employee_id =160

select * from jobs where job_id = 'SA_REP'