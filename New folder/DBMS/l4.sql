
1.
SELECT * FROM all_tables
where table_name in ('DEPT', 'EMP');

2.
select owner, table_name, comments from all_col_comments
where table_name= 'EMPLOYEES';

3.
SELECT ac.constraint_name,
       acc.column_name,
       ac.owner AS table_owner
FROM all_constraints ac
JOIN all_cons_columns acc
  ON ac.constraint_name = acc.constraint_name
 AND ac.owner = acc.owner
WHERE ac.table_name = 'EMPLOYEES'
  AND ac.constraint_type = 'P';

4. 
SELECT table_name
FROM user_tables
MINUS
SELECT table_name
FROM user_constraints
WHERE constraint_type = 'P';

5. 
SELECT table_name
FROM user_tables
MINUS
SELECT table_name
FROM user_constraints
WHERE constraint_type = 'F';

6.
SELECT
ac.table_name,
ac.owner,
ac.constraint_name foreign_key_name,
acc.column_name foreign_key_column,
acpk.table_name referenced_table,
acpk.constraint_name referenced_pk_constraint
FROM all_constraints ac
JOIN all_cons_columns acc ON ac.owner = acc.owner AND ac.constraint_name = acc.constraint_name
JOIN all_constraints acpk ON ac.r_owner = acpk.owner AND ac.r_constraint_name = acpk.constraint_name
WHERE ac.table_name = 'JOB_HISTORY'
AND ac.constraint_type = 'R'
AND ac.owner = 'WKSP*';

7.
SELECT
ac.table_name,
ac.owner,
ac.constraint_name foreign_key_name,
acc.column_name foreign_key_column,
accpk.table_name referenced_table,
accpk.constraint_name referenced_pk_constraint,
accpk.column_name pk_column
FROM all_constraints ac
JOIN all_cons_columns acc ON ac.owner = acc.owner AND ac.constraint_name = acc.constraint_name
JOIN all_cons_columns accpk ON ac.owner = accpk.owner AND ac.r_constraint_name = accpk.constraint_name
WHERE ac.table_name = 'JOB_HISTORY'
AND ac.constraint_type = 'R'
AND ac.owner = 'WKSP_*';

8.
SELECT
accfk.column_name,
accfk.constraint_name,
accfk.table_name,
accpk.column_name coloana_pk,
accpk.constraint_name constrangere_pk,
accpk.table_name tabel_pk
FROM user_cons_columns accfk
JOIN user_constraints acfk ON acfk.constraint_name = accfk.constraint_name
JOIN user_cons_columns accpk ON acfk.r_constraint_name = accpk.constraint_name
WHERE accpk.table_name = 'EMPLOYEES'
AND acfk.constraint_type = 'R';


9.
select column_name, updatable
from user_updatable_columns;

10.
select column_name
from   user_tab_columns
where  table_name = 'EMPLOYEES'
and    nullable = 'Y';

11.
select table_name
from   user_tab_columns
minus 
select table_name
from user_tab_columns where nullable = 'Y';

12.
select ui.index_name,
       ui.table_name,
       uic.column_name,
       uic.column_position
from   user_indexes ui
       join user_ind_columns uic
         on ui.index_name = uic.index_name
order  by ui.table_name,
          ui.index_name,
          uic.column_position;
