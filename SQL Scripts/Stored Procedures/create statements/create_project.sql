CREATE OR REPLACE PROCEDURE create_project 
(
	project_id IN VARCHAR2,
	name IN	VARCHAR2,
	description IN VARCHAR2,
	cost IN	FLOAT,
	total_donation IN FLOAT
) 
IS
BEGIN

	INSERT INTO Project
	VALUES(project_id, name, description, cost, 0.00);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'Project ID already exists / duplicate id');

END create_project;