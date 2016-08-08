CREATE OR REPLACE PROCEDURE find_project
(
	project_name IN Project.name%TYPE,

	out_id OUT Project.project_id%TYPE,
	out_name OUT Project.name%TYPE,
	out_desc OUT Project.description%TYPE,
	out_cost OUT Project.cost%TYPE,
	out_total_donation OUT Project.total_donation%TYPE		
) 
IS
BEGIN

	select project_id, name, description, cost, total_donation 
	into out_id, out_name, out_desc, out_cost, out_total_donation
	from project
	where name = project_name;

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_project;