CREATE OR REPLACE PROCEDURE update_project
(
	p_id IN VARCHAR2,
	p_name IN VARCHAR2,
	p_description IN VARCHAR2,
	p_cost IN FLOAT,
	p_donations IN FLOAT
) 
IS
BEGIN

	UPDATE Project
	SET name = p_name, description = p_description, cost = p_cost,
	total_donation = p_donations
	where project_id = p_id

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_project;