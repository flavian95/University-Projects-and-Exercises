
1.
create or replace procedure HelloWorld is
begin
   DBMS_OUTPUT.PUT_LINE('Hello World');
end HelloWorld;
/

drop procedure HelloWorld;

CREATE OR REPLACE PROCEDURE hello (
   p_name IN VARCHAR2
) IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('Hello ' || p_name);
END hello;
/

BEGIN
   hello('Name');
END;
/

2.
create table jobs_flavian
as select * from jobs;

alter table jobs_flavian add constraint job_id_PK primary key (job_id);


CREATE OR REPLACE PROCEDURE add_job_flavian (
   p_id    IN jobs_flavian.job_id%TYPE,
   p_title IN jobs_flavian.job_title%TYPE
) IS
BEGIN
   INSERT INTO jobs_flavian (job_id, job_title)
   VALUES (p_id, p_title);

   COMMIT;

EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Job already exists in the table.');
END add_job_flavian;
/

3.
create procedure UPD_JOB_Flavian(
    v_job_id in jobs_Flavian.job_id%TYPE,
    v_job_title in jobs_Flavian.job_title%TYPE
)
is
  BEGIN
   UPDATE jobs_flavian
   SET job_title = p_job_title
   WHERE job_id = p_job_id;

   IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Job does not exist in the table.');
   ELSE
      COMMIT;
   END IF;

END upd_job_flavian;
/

4.
create procedure DEL_JOB_FLAVIAN(
    v_job_id in jobs_Flavian.job_id%TYPE
)
is
BEGIN
   delete from jobs_flavian
   where job_id =v_job_id;

   IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Job does not exist in the table.');
   ELSE
      COMMIT;
   END IF;
END
/