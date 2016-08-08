CREATE OR REPLACE PROCEDURE update_donor
(
	d_id IN VARCHAR2,
	d_name IN VARCHAR2,
	d_email IN VARCHAR2	
) 
IS
BEGIN

	UPDATE Donor
	SET name = d_name, email = d_email
	where donor_id = d_id

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_donor;