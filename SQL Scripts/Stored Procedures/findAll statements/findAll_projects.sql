CREATE OR REPLACE PROCEDURE findALL_projects
(
	project_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN project_cursor FOR
		SELECT project_id, name,  description, cost, total_donation
		FROM Project;


END findALL_projects;