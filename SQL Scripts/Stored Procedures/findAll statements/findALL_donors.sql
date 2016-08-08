CREATE OR REPLACE PROCEDURE findALL_donors
(
	proj_id IN Project.project_id%TYPE,
	donor_cursor out SYS_REFCURSOR
)
IS
BEGIN
	OPEN donor_cursor FOR
		SELECT donor_id, name, email 
		FROM Donor;

END findALL_donors;