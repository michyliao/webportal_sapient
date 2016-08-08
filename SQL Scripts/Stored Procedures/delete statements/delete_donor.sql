CREATE OR REPLACE PROCEDURE delete_donor 
(
	d_id IN VARCHAR2
)
IS
BEGIN

	DELETE FROM Donor
	where donor_id = d_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_donor;