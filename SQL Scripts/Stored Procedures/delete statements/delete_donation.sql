CREATE OR REPLACE PROCEDURE delete_donation 
(
	d_id IN VARCHAR2
)
IS
BEGIN

	DELETE FROM Donations
	where donation_id = d_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_donation;